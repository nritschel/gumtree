/*
 * This file is part of GumTree.
 *
 * GumTree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GumTree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GumTree.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2011-2015 Jean-Rémy Falleri <jr.falleri@gmail.com>
 * Copyright 2011-2015 Floréal Morandat <florealm@gmail.com>
 */

package com.github.gumtreediff.gen.js;

import com.github.gumtreediff.tree.ITree;
import com.github.gumtreediff.tree.TreeContext;
import com.oracle.js.parser.ir.*;
import com.oracle.js.parser.ir.visitor.NodeVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GraalJSTreeVisitor extends NodeVisitor<LexicalContext> {

    private Map<Node, ITree> trees;
    private Stack<Node> currentParentChain;
    private TreeContext context;

    public GraalJSTreeVisitor(Node root, LexicalContext lex) {
        super(lex);
        trees = new HashMap<>();
        context = new TreeContext();
        currentParentChain = new Stack<>();

        buildTree(root);
    }

    public TreeContext getTree(Node root) {
        context.setRoot(trees.get(root));
        return context;
    }

    private void beforeVisit(Node node) {
        ITree t = buildTree(node);
        if (!currentParentChain.empty()) {
            ITree p = trees.get(currentParentChain.peek());
            p.addChild(t);
        }
        currentParentChain.push(node);
    }

    private void afterVisit(Node node) {
        currentParentChain.pop();
    }

    @Override
    protected boolean enterDefault(Node node) {
        beforeVisit(node);
        return super.enterDefault(node);
    }

    @Override
    protected Node leaveDefault(Node node) {
        afterVisit(node);
        return super.leaveDefault(node);
    }

    @Override
    public boolean enterIdentNode(IdentNode node) {
        beforeVisit(node);
        if (node.getName() != null)
            trees.get(node).setLabel(node.getName());
        return super.enterDefault(node);
    }

    @Override
    public boolean enterAccessNode(AccessNode node) {
        beforeVisit(node);
        if (node.getProperty() != null)
            trees.get(node).setLabel(node.getProperty());
        return super.enterDefault(node);
    }

    @Override
    public boolean enterPropertyNode(PropertyNode node) {
        beforeVisit(node);
        if (node.getKeyName() != null)
            trees.get(node).setLabel(node.getKeyName());
        return super.enterDefault(node);
    }

    private ITree buildTree(Node node)  {
        ITree t = context.createTree(node.tokenType().ordinal(), ITree.NO_LABEL, node.tokenType().getNameOrType());
        t.setPos(node.getStart());
        t.setLength(node.getFinish() - node.getStart());
        trees.put(node, t);
        return t;
    }

}

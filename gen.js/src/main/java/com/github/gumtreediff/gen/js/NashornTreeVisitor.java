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
import jdk.nashorn.api.tree.*;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NashornTreeVisitor extends SimpleTreeVisitorES6<Object, Object> {

    private Map<Tree, ITree> trees;
    private Stack<Tree> currentParentChain;
    private TreeContext context;

    public NashornTreeVisitor(CompilationUnitTree root) {
        trees = new HashMap<>();
        context = new TreeContext();
        currentParentChain = new Stack<>();
        ITree tree = buildTree(root);
        context.setRoot(tree);
    }

    public TreeContext getTree(Tree root) {
        return context;
    }

    private void beforeVisit(Tree node, Object o) {
        ITree t = buildTree(node);
        ITree p = trees.get(currentParentChain.peek());
        p.addChild(t);
        currentParentChain.push(node);
    }

    private void afterVisit(Tree node, Object o) {
        currentParentChain.pop();
    }

    @Override
    public Object visitCompilationUnit(CompilationUnitTree node, Object r) {
        currentParentChain.push(node);
        Object returnVal = super.visitCompilationUnit(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitModule(ModuleTree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitModule(node, o);
        afterVisit(node, o);
        return returnVal;
    }

    @Override
    public Object visitExportEntry(ExportEntryTree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitExportEntry(node, o);
        afterVisit(node, o);
        return returnVal;
    }

    @Override
    public Object visitImportEntry(ImportEntryTree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitImportEntry(node, o);
        afterVisit(node, o);
        return returnVal;
    }

    @Override
    public Object visitClassDeclaration(ClassDeclarationTree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitClassDeclaration(node, o);
        afterVisit(node, o);
        return returnVal;
    }

    @Override
    public Object visitClassExpression(ClassExpressionTree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitClassExpression(node, o);
        afterVisit(node, o);
        return returnVal;
    }

    @Override
    public Object visitForOfLoop(ForOfLoopTree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitForOfLoop(node, o);
        afterVisit(node, o);
        return returnVal;
    }

    @Override
    public Object visitYield(YieldTree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitYield(node, o);
        afterVisit(node, o);
        return returnVal;
    }

    @Override
    public Object visitSpread(SpreadTree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitSpread(node, o);
        afterVisit(node, o);
        return returnVal;
    }

    @Override
    public Object visitTemplateLiteral(TemplateLiteralTree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitTemplateLiteral(node, o);
        afterVisit(node, o);
        return returnVal;
    }

    @Override
    public Object visitVariable(VariableTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitVariable(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitAssignment(AssignmentTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitAssignment(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitCompoundAssignment(CompoundAssignmentTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitCompoundAssignment(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitBinary(BinaryTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitBinary(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitBlock(BlockTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitBlock(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitBreak(BreakTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitBreak(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitCase(CaseTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitCase(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitCatch(CatchTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitCatch(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitConditionalExpression(ConditionalExpressionTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitConditionalExpression(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitContinue(ContinueTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitContinue(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitDebugger(DebuggerTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitDebugger(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitDoWhileLoop(DoWhileLoopTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitDoWhileLoop(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitErroneous(ErroneousTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitErroneous(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatementTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitExpressionStatement(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitForLoop(ForLoopTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitForLoop(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitForInLoop(ForInLoopTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitForInLoop(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitFunctionCall(FunctionCallTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitFunctionCall(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitFunctionDeclaration(FunctionDeclarationTree node, Object r) {
        beforeVisit(node, r);
        node.getName().accept(this, r);
        Object returnVal = super.visitFunctionDeclaration(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitFunctionExpression(FunctionExpressionTree node, Object r) {
        beforeVisit(node, r);
        node.getName().accept(this, r);
        Object returnVal = super.visitFunctionExpression(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitIf(IfTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitIf(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitArrayAccess(ArrayAccessTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitArrayAccess(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitArrayLiteral(ArrayLiteralTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitArrayLiteral(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitLabeledStatement(LabeledStatementTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitLabeledStatement(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitParenthesized(ParenthesizedTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitParenthesized(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitReturn(ReturnTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitReturn(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitMemberSelect(MemberSelectTree node, Object r) {
        beforeVisit(node, r);
        trees.get(node).setLabel(node.getIdentifier());
        Object returnVal = super.visitMemberSelect(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitNew(NewTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitNew(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitObjectLiteral(ObjectLiteralTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitObjectLiteral(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitProperty(PropertyTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitProperty(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitRegExpLiteral(RegExpLiteralTree node, Object r) {
        beforeVisit(node, r);
        trees.get(node).setLabel(node.getPattern());
        Object returnVal = super.visitRegExpLiteral(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitEmptyStatement(EmptyStatementTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitEmptyStatement(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitSwitch(SwitchTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitSwitch(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitThrow(ThrowTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitThrow(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitTry(TryTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitTry(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitIdentifier(IdentifierTree node, Object r) {
        beforeVisit(node, r);
        trees.get(node).setLabel(node.getName());
        Object returnVal = super.visitIdentifier(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitLiteral(LiteralTree node, Object r) {
        beforeVisit(node, r);
        Object value = node.getValue();
        if (value != null) {
            trees.get(node).setLabel(node.getValue().toString());
        }
        else {
            trees.get(node).setLabel("null");
        }
        Object returnVal = super.visitLiteral(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitInstanceOf(InstanceOfTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitInstanceOf(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitUnary(UnaryTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitUnary(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitWhileLoop(WhileLoopTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitWhileLoop(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitWith(WithTree node, Object r) {
        beforeVisit(node, r);
        Object returnVal = super.visitWith(node, r);
        afterVisit(node, r);
        return returnVal;
    }

    @Override
    public Object visitUnknown(Tree node, Object o) {
        beforeVisit(node, o);
        Object returnVal = super.visitUnknown(node, o);
        afterVisit(node, o);
        return returnVal;
    }


    private ITree buildTree(Tree node)  {
        ITree t = context.createTree(node.getKind().ordinal(), ITree.NO_LABEL, node.getKind().name() );
        t.setPos((int)node.getStartPosition());
        t.setLength((int)(node.getEndPosition() - node.getStartPosition()));
        trees.put(node, t);
        return t;
    }

}

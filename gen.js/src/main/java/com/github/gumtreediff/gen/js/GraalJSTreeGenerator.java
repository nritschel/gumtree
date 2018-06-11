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
 * Copyright 2011 Jean-Rémy Falleri
 */

package com.github.gumtreediff.gen.js;

import com.github.gumtreediff.gen.Register;
import com.github.gumtreediff.gen.Registry;
import com.github.gumtreediff.gen.TreeGenerator;
import com.github.gumtreediff.tree.TreeContext;
import com.oracle.js.parser.ErrorManager;
import com.oracle.js.parser.Parser;
import com.oracle.js.parser.ScriptEnvironment;
import com.oracle.js.parser.Source;
import com.oracle.js.parser.ir.FunctionNode;
import com.oracle.js.parser.ir.LexicalContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

@Register(id = "js-graal", accept = "\\.js$", priority = Registry.Priority.MAXIMUM)
public class GraalJSTreeGenerator extends TreeGenerator {
    private String fileName;

    public GraalJSTreeGenerator(String fileName) {
        this.fileName = fileName;
    }

    public GraalJSTreeGenerator() {
        this.fileName = "";
    }

    @Override
    public TreeContext generate(Reader r) throws IOException {
        BufferedReader reader = new BufferedReader(r);
        StringBuilder stringBuilder = new StringBuilder();
        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            stringBuilder.append(inputLine);
            stringBuilder.append(System.lineSeparator());
        }

        Parser parser = new Parser(ScriptEnvironment.builder().build(), Source.sourceFor(fileName,stringBuilder.toString()), new ErrorManager.ThrowErrorManager());

        FunctionNode node = parser.parseModule("");
        LexicalContext ctx = new LexicalContext();
        GraalJSTreeVisitor visitor = new GraalJSTreeVisitor(node, ctx);
        node.accept(ctx, visitor);
        return visitor.getTree(node);
    }
}

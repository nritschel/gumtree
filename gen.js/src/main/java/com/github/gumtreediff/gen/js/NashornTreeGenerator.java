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
import jdk.nashorn.api.tree.CompilationUnitTree;
import jdk.nashorn.api.tree.Parser;

import java.io.IOException;
import java.io.Reader;

@Register(id = "js-nashorn", accept = "\\.js$", priority = Registry.Priority.HIGH)
public class NashornTreeGenerator extends TreeGenerator {

    @Override
    public TreeContext generate(Reader r) throws IOException {
        Parser nashornParser = Parser.create("--language=es6", "--es6-module");
        CompilationUnitTree jsTree = nashornParser.parse("dummy.js", r, null);

        NashornTreeVisitor visitor = new NashornTreeVisitor(jsTree);
        jsTree.accept(visitor, null);
        return visitor.getTree(jsTree);
    }
}

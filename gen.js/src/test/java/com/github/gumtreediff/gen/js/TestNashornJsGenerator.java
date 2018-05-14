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
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.Assert.assertEquals;

public class TestNashornJsGenerator {

    @Test
    public void testStatement() throws IOException {
        String input = "console.log(\"Hello world!\");";
        ITree tree = new NashornTreeGenerator().generateFromString(input).getRoot();
        assertEquals(6, tree.getSize());
    }

    // Nashorn does not parse comments!
    @Test
    public void testComment() throws IOException {
        String input = "console.log(\"Hello world!\"); /* with comment */";
        ITree tree = new NashornTreeGenerator().generateFromString(input).getRoot();
        assertEquals(6, tree.getSize());
    }

    @Test
    public void testComplexFile() throws IOException {
        Reader r = new InputStreamReader(getClass().getResourceAsStream("/sample.js"), "UTF-8");
        ITree tree = new NashornTreeGenerator().generateFromReader(r).getRoot();
        assertEquals(347, tree.getSize());
    }

}

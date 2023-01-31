package com.diamond.kata;

import com.diamond.kata.util.DiamondUtil;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

public class DiamondUtilTest {

    private DiamondUtil diamondUtil = new DiamondUtil();

    /*
    @Test
    public void testWithoutSpace() {
        DiamondUtil diamondUtil = new DiamondUtil();
        assertEquals( "A", diamondUtil.draw('A', '_') );
        assertEquals( "A\r\nB\r\nA", diamondUtil.draw('B','_') );
        assertEquals( "A\r\nB\r\nC\r\nB\r\nA", diamondUtil.draw('C','_') );
        assertEquals( "A\r\nB\r\nC\r\nD\r\nC\r\nB\r\nA", diamondUtil.draw('D','_') );
    }
     */

    @Test
    public void testWithWrongChar() {
        assertEquals( "", diamondUtil.draw('0', '_') );
        assertEquals( "", diamondUtil.draw(' ', '_') );
    }

    @Test
    public void testWithUnderscore() {
        assertEquals( "A", diamondUtil.draw('A', '_') );
        assertEquals( "_A_\r\nB_B\r\n_A_", diamondUtil.draw('B','_') );
        assertEquals( "__A__\r\n_B_B_\r\nC___C\r\n_B_B_\r\n__A__", diamondUtil.draw('C','_') );
        assertEquals( "___A___\r\n__B_B__\r\n_C___C_\r\nD_____D\r\n_C___C_\r\n__B_B__\r\n___A___", diamondUtil.draw('D','_') );
    }

    @Test
    public void testWithSpace() {
        assertEquals( "A", diamondUtil.draw('A', ' ') );
        assertEquals( " A \r\nB B\r\n A ", diamondUtil.draw('B',' ') );
        assertEquals( "  A  \r\n B B \r\nC   C\r\n B B \r\n  A  ", diamondUtil.draw('C',' ') );
        assertEquals( "   A   \r\n  B B  \r\n C   C \r\nD     D\r\n C   C \r\n  B B  \r\n   A   ", diamondUtil.draw('D',' ') );
    }

}

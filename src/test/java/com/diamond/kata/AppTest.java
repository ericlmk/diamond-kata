package com.diamond.kata;

import static junit.framework.TestCase.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    private final PrintStream originalErr = System.err;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream errStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
        System.setErr(new PrintStream(errStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testNoArg() {
        App.main(new String[]{});
        assertEquals( "Please input 1 argument\r\n", errStream.toString() );
        assertEquals( "", outStream.toString() );
    }

    @Test
    public void test2Arg() {
        App.main(new String[]{"A", "B"});
        assertEquals( "Please input 1 argument\r\n", errStream.toString() );
        assertEquals( "", outStream.toString() );
    }

    @Test
    public void testArgWithMoreThan1Char() {
        App.main(new String[]{"AA"});
        assertEquals( "Please input correct argument with 1 character\r\n", errStream.toString() );
        assertEquals( "", outStream.toString() );
    }

    @Test
    public void testWrongChar() {
        App.main(new String[]{"0"});
        assertEquals( "Please input the argument between 'A' to 'Z'\r\n", errStream.toString() );
        assertEquals( "", outStream.toString() );
    }

    @Test
    public void testA() {
        App.main(new String[]{"A"});
        assertEquals( "A\r\n", outStream.toString() );
        assertEquals( "", errStream.toString() );
    }

    @Test
    public void testB() {
        App.main(new String[]{"B"});
        assertEquals( " A \r\nB B\r\n A \r\n", outStream.toString() );
        assertEquals( "", errStream.toString() );
    }

    @Test
    public void testC() {
        App.main(new String[]{"C"});
        assertEquals( "  A  \r\n B B \r\nC   C\r\n B B \r\n  A  \r\n", outStream.toString() );
        assertEquals( "", errStream.toString() );
    }

}

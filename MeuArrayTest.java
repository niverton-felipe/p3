package p3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeuArrayTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void size(){
        MeuArray meuArray = new MeuArray();
        assertEquals(0, meuArray.size());
    }

    @Test
    void testAdd1() throws ValorInvaidoException{
        MeuArray meuArray = new MeuArray();
        int expectedValue = 1;
        for(int i = 0; i < expectedValue; i++){
            meuArray.add("Elemento " + i);
        }
        assertEquals(expectedValue, meuArray.size());
    }

    @Test
    void testAdd5(){
        MeuArray meuArray = new MeuArray();
        Assertions.assertThrows(ValorInvaidoException.class, () ->
               meuArray.add(null) );
    }
}
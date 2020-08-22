import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {
    SimpleHashMap simpleHashMap;
    @BeforeEach
    void setUp() {
        simpleHashMap = new SimpleHashMap();
    }

    @Test
    void putKeyValueAndGetByTheKeyRelatedValue() {
        simpleHashMap.put(1, 111);
        simpleHashMap.put(2, 112);
        simpleHashMap.put(3, 113);
        simpleHashMap.put(4, 114);
        simpleHashMap.put(5, 115);
        simpleHashMap.put(6, 116);
        simpleHashMap.put(7, 117);
        simpleHashMap.put(8, 118);
        simpleHashMap.put(8, 119);
        simpleHashMap.put(9, 121);
        simpleHashMap.put(10, 122);
        simpleHashMap.put(11, 123);

        /**
         * check if the put than get is working
         */
        assertEquals(113,simpleHashMap.get(3));

    }
    @Test
    void shiftingKey(){
        int lengthTest = 31;
        for (int i = 0; i < lengthTest; i++) {
            simpleHashMap.put(i, i + i);
        }
        /**
         *
         * check if the Key has shifted on a match
         */
        assertEquals(10,simpleHashMap.get(5));
        assertEquals(20,simpleHashMap.get(10));
        assertEquals(4,simpleHashMap.get(2));
        assertEquals(6,simpleHashMap.get(3));

    }

    @Test
    void getSize(){
        int lengthTest = 31;
        for (int i = 0; i < lengthTest; i++) {
            simpleHashMap.put(i, i);
        }
        assertEquals(lengthTest, simpleHashMap.size());
    }
}
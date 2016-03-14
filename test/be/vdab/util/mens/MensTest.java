/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

import java.util.Arrays;
import java.util.EnumSet;
import org.junit.*;
import static org.junit.Assert.*;
import static be.vdab.util.mens.Rijbewijs.*;
import be.vdab.voertuigen.MensFactorInTest;

/**
 *
 * @author joris.geboers
 */
public class MensTest {

    @Test
    public void test_equals_zichzelf() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        assertTrue(BESTUURDER_A.equals(BESTUURDER_A));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void test_not_equals_null() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        assertFalse(BESTUURDER_A.equals(null));
    }

    @Test
    public void test_equals_Mens() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Andree", A);
        assertTrue(BESTUURDER_A.equals(BESTUURDER_B));
    }

    @Test
    public void not_equals_Mens() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Bernard", B);
        assertFalse(BESTUURDER_A.equals(BESTUURDER_B));
        assertFalse(BESTUURDER_B.equals(BESTUURDER_A));
    }

    @Test
    public void not_equals_MensNaam() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Bernard", A);
        assertFalse(BESTUURDER_A.equals(BESTUURDER_B));
        assertFalse(BESTUURDER_B.equals(BESTUURDER_A));
    }

    @Test
    public void not_equals_MensRijbewijs() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Andree", B);
        assertFalse(BESTUURDER_A.equals(BESTUURDER_B));
        assertFalse(BESTUURDER_B.equals(BESTUURDER_A));
    }

    @Test
    public void test_equals_Mens_Symmetrisch() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Andree", A);
        assertTrue(BESTUURDER_A.equals(BESTUURDER_B));
        assertTrue(BESTUURDER_B.equals(BESTUURDER_A));
    }

    @Test
    public void test_hashCode_equals() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Andree", A);
        assertEquals((BESTUURDER_A.hashCode() == BESTUURDER_B.hashCode()), BESTUURDER_A.equals(BESTUURDER_B));
    }

    @Test
    public void test_hashCode_not_equals() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Bernard", B);
        assertFalse(BESTUURDER_A.hashCode() == BESTUURDER_B.hashCode());
        assertFalse(BESTUURDER_A.equals(BESTUURDER_B));
    }

    @Test
    public void test_compareTo() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Bernard", B);
        assertEquals(BESTUURDER_A.compareTo(BESTUURDER_B) < 0, BESTUURDER_A.getNaam().compareTo(BESTUURDER_B.getNaam()) < 0);
        assertEquals(BESTUURDER_A.compareTo(BESTUURDER_A) == 0, BESTUURDER_A.getNaam().compareTo(BESTUURDER_A.getNaam()) == 0);
        assertEquals(BESTUURDER_B.compareTo(BESTUURDER_A) > 0, BESTUURDER_B.getNaam().compareTo(BESTUURDER_A.getNaam()) > 0);
    }

    @Test
    public void test_equals_trasitief() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Andree", A);
        Mens BESTUURDER_C = new Mens("Andree", A);
        assertTrue(BESTUURDER_A.equals(BESTUURDER_B));
        assertTrue(BESTUURDER_B.equals(BESTUURDER_C));
        assertTrue(BESTUURDER_A.equals(BESTUURDER_C));
    }
    
    @Test
    public void test_equals_minder_Rijbewijzen() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Andree", A, B);
        assertFalse(BESTUURDER_A.equals(BESTUURDER_B));
    }
    
    @Test
    public void test_equals_meer_Rijbewijzen() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        Mens BESTUURDER_B = new Mens("Andree", A, B);
        assertFalse(BESTUURDER_B.equals(BESTUURDER_A));
    }

    /*
     * zien of dezelfde naam eruit komt
     * hetzelfde rijbeijs
     * meer dan 1 rijbewijs , unieke rijbewijzen
     */
    @Test
    public void test_getNaam() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        assertEquals("Andree", BESTUURDER_A.getNaam());
    }

    @Test
    public void test_getRijbewijs() {
        Mens BESTUURDER_A = new Mens("Andree", A);
        assertEquals(A, BESTUURDER_A.getRijbewijs()[0]);
    }

    public void test_getRijbewijzen_van_Ingezetene_zonder_rijbewijs() {
        assertArrayEquals(new Mens[0],MensFactorInTest.INGEZETENE_A.getRijbewijs());
    }
   
    @Test
    public void test_getRijbewijzen() {
        Mens BESTUURDER_A = new Mens("Andree", A, B);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(A, B)));
        BESTUURDER_A = new Mens("Andree", A, B, BE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(A, BE)));
        BESTUURDER_A = new Mens("Andree", A, B, BE, C);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(A, C)));
        BESTUURDER_A = new Mens("Andree", A, B, BE, C, CE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(A, CE)));
        BESTUURDER_A = new Mens("Andree", A, B, BE, C, CE, D);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(A, D)));
        BESTUURDER_A = new Mens("Andree", A, B, BE, C, CE, D, DE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(A, DE)));
        //----B
        BESTUURDER_A = new Mens("Andree", B, BE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(B, BE)));
        BESTUURDER_A = new Mens("Andree", B, BE, C);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(B, C)));
        BESTUURDER_A = new Mens("Andree", B, BE, C, CE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(B, CE)));
        BESTUURDER_A = new Mens("Andree", B, BE, C, CE, D);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(B, D)));
        BESTUURDER_A = new Mens("Andree", B, BE, C, CE, D, DE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(B, DE)));
        //----BE
        BESTUURDER_A = new Mens("Andree", BE, C);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(BE, C)));
        BESTUURDER_A = new Mens("Andree", BE, C, CE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(BE, CE)));
        BESTUURDER_A = new Mens("Andree", BE, C, CE, D);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(BE, D)));
        BESTUURDER_A = new Mens("Andree", BE, C, CE, D, DE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(BE, DE)));
        //----C
        BESTUURDER_A = new Mens("Andree", C, CE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(C, CE)));
        BESTUURDER_A = new Mens("Andree", C, CE, D);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(C, D)));
        BESTUURDER_A = new Mens("Andree", C, CE, D, DE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(C, DE)));
        //----CE
        BESTUURDER_A = new Mens("Andree", CE, D);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(CE, D)));
        BESTUURDER_A = new Mens("Andree", CE, D, DE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(CE, DE)));
        //----D
        BESTUURDER_A = new Mens("Andree", D, DE);
        assertTrue(Arrays.asList(BESTUURDER_A.getRijbewijs()).containsAll(EnumSet.range(D, DE)));
    }

    @Test
    public void test_getUniekeRijbewijzen() {
        Mens BESTUURDER_A = new Mens("Andree", A, A);
        assertEquals(1,BESTUURDER_A.getRijbewijs().length);
        Mens BESTUURDER_B = new Mens("Bea", A, B, BE, A);
        assertEquals(3,BESTUURDER_B.getRijbewijs().length);
    }

    @Test
    public void test_toString_Mens_Zonder_rijbewijs(){
        String expected = "Anita";
        assertEquals(expected, MensFactorInTest.INGEZETENE_A.toString());
    }
    
    @Test
    public void test_toString_Mens_Met_Eén_rijbewijs(){
        String expected = "Andree(A)";
        String intecht = MensFactorInTest.BESTUURDER_A.toString();
        assertEquals(expected, intecht);
    }

    @Test
    public void test_toString_Mens_Met_rijbewijzen(){
        String expected = "Ammelie(B, B+E, C, C+E)";
        assertEquals(expected, MensFactorInTest.BESTUURDER_BBECCE.toString());
    }

}

/*
* @Autor Frank
* Dit is een oefening.
 */
package be.vdab.schoolgerief;

import be.vdab.util.Maat;
import be.vdab.util.VolumeException;
import org.junit.*;
import static org.junit.Assert.*;
import be.vdab.util.Volume;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author frank.roelants
 */
public class BoekentasTest {

//  private final Volume VOLUME10;
//  private final Volume VOLUME12;
//  private final String KLEUR1 = "geel";
//  private final String KLEUR2 = "blauw";
//  private final String VOLUME10_STRING;
//
//  public BoekentasTest() throws VolumeException {
//    VOLUME10 = new Volume(10, 10, 10, Maat.decimeter);
//    VOLUME12 = new Volume(12, 12, 12, Maat.decimeter);
//    VOLUME10_STRING = VOLUME10.toString();
//  }
//
//  @Test
//  public void test_not_null() {
//    assertNotNull(new Boekentas(KLEUR1, VOLUME10));
//  }
//
//  @Test
//  public void test_getKleur() {
//    assertNotNull(new Boekentas(KLEUR1, VOLUME10).getKleur());
//  }
//
//  @Test
//  public void test_getMerk() {
//    assertNotNull(new Boekentas(KLEUR1, VOLUME10).getLaadvolume());
//  }
//
//  @Test
//  public void test_getKleurValue() {
//    assertEquals(new Boekentas(KLEUR1, VOLUME10).getKleur(), KLEUR1);
//  }
//
//  @Test
//  public void test_getMerkValue() {
//    assertEquals(new Boekentas(KLEUR1, VOLUME10).getLaadvolume(), VOLUME10);
//  }
//
//  @Test
//  public void test_setKleur() {
//    Boekentas b = new Boekentas(KLEUR1, VOLUME10);
//    b.setKleur(KLEUR2);
//    assertFalse(b.getKleur().equals(KLEUR1));
//    assertTrue(b.getKleur().equals(KLEUR2));
//  }
//
//  @Test
//  public void test_setVolume() {
//    Boekentas b = new Boekentas(KLEUR1, VOLUME10);
//    b.setLaadvolume(VOLUME12);
//    assertFalse(b.getLaadvolume().equals(VOLUME10));
//    assertTrue(b.getLaadvolume().equals(VOLUME12));
//  }
//
//  @Test(expected = java.lang.IllegalArgumentException.class)
//  public void test_setKleur_null() {
//    Boekentas b = new Boekentas(KLEUR1, VOLUME10);
//    b.setKleur(null);
//  }
//
//  @Test(expected = java.lang.IllegalArgumentException.class)
//  public void test_setVolume_null() {
//    Boekentas b = new Boekentas(KLEUR1, VOLUME10);
//    b.setLaadvolume(null);
//  }
//
//  @Test(expected = java.lang.IllegalArgumentException.class)
//  public void test_Constructor_Kleur_null() {
//    Boekentas b = new Boekentas(null, VOLUME10);
//  }
//
//  @Test(expected = java.lang.IllegalArgumentException.class)
//  public void test_Constructor_Volume_null() {
//    Boekentas b = new Boekentas(KLEUR1, null);
//  }
//
//  @Test
//  public void test_equals_zichzelf() {
//    Boekentas b1 = new Boekentas(KLEUR1, VOLUME10);
//    assertTrue(b1.equals(b1));
//  }
//
//  @Test
//  public void test_not_equals_null() {
//    Boekentas d1 = new Boekentas(KLEUR1, VOLUME10);
//    assertFalse(d1.equals(null));
//  }
//
//  @Test
//  public void test_equals_Boekentas() {
//    Boekentas d1 = new Boekentas(KLEUR1, VOLUME10);
//    Boekentas d2 = new Boekentas(KLEUR1, VOLUME10);
//    assertTrue(d1.equals(d2));
//    assertTrue(d2.equals(d2));
//  }
//
//  @Test
//  public void test_not_equals_Boekentas() {
//    Boekentas d1 = new Boekentas(KLEUR1, VOLUME10);
//    Boekentas d2 = new Boekentas(KLEUR2, VOLUME10);
//    Boekentas d3 = new Boekentas(KLEUR1, VOLUME12);
//    Boekentas d4 = new Boekentas(KLEUR2, VOLUME12);
//    assertFalse(d1.equals(d2));
//    assertFalse(d2.equals(d1));
//    assertFalse(d1.equals(d3));
//    assertFalse(d3.equals(d1));
//    assertFalse(d1.equals(d4));
//    assertFalse(d4.equals(d1));
//  }
//
//  @Test
//  public void test_equals_Symetie() {
//    Boekentas d1 = new Boekentas(KLEUR1, VOLUME10);
//    Boekentas d2 = new Boekentas(KLEUR1, VOLUME10);
//    assertTrue(d1.equals(d2));
//    assertTrue(d2.equals(d1));
//  }
//
//  @Test
//  public void test_equals_trasitief() {
//    Boekentas d1 = new Boekentas(KLEUR1, VOLUME10);
//    Boekentas d2 = new Boekentas(KLEUR1, VOLUME10);
//    Boekentas d3 = new Boekentas(KLEUR1, VOLUME10);
//    assertTrue(d1.equals(d2));
//    assertTrue(d2.equals(d3));
//    assertTrue(d1.equals(d3));
//  }
//
//  @Test
//  public void test_hashCode_equals() {
//    Boekentas d1 = new Boekentas(KLEUR1, VOLUME10);
//    Boekentas d2 = new Boekentas(KLEUR1, VOLUME10);
//    assertEquals(d1.hashCode(), d2.hashCode());
//    assertEquals(d1, d2);
//  }
//
//  @Test
//  public void test_hashCode_not_equals() {
//    Boekentas d1 = new Boekentas(KLEUR1, VOLUME10);
//    Boekentas d2 = new Boekentas(KLEUR2, VOLUME10);
//    Boekentas d3 = new Boekentas(KLEUR1, VOLUME12);
//    Boekentas d4 = new Boekentas(KLEUR2, VOLUME12);
//    assertFalse(d1.hashCode() == d2.hashCode());
//    assertFalse(d1.equals(d2));
//    assertFalse(d1.hashCode() == d3.hashCode());
//    assertFalse(d1.equals(d3));
//    assertFalse(d1.hashCode() == d4.hashCode());
//    assertFalse(d1.equals(d4));
//  }
//
//  @Test
//  public void test_toString() {
//    Boekentas d1 = new Boekentas(KLEUR1, VOLUME10);
//    String toString = String.format("boekentas %s %s",KLEUR1, VOLUME10_STRING);
//    String toString2 = d1.toString();
//    assertEquals(toString, toString2);
//  }
//
//  @Test
//  public void test_Boekentas_is_it_Serializable() throws IOException, VolumeException {
//    ByteArrayOutputStream out = new ByteArrayOutputStream();
//    ObjectOutputStream oos = new ObjectOutputStream(out);
//    oos.writeObject(new Boekentas(KLEUR1, VOLUME10));
//    oos.close();
//    assertTrue(out.toByteArray().length > 0);
//  }
//
//  @Test
//  public void test_Boekentas_Serializable_and_equals_to_the_original() throws IOException, ClassNotFoundException, VolumeException {
//    final Boekentas origineel = new Boekentas(KLEUR1, VOLUME10);
//    ByteArrayOutputStream out = new ByteArrayOutputStream();
//    ObjectOutputStream oos = new ObjectOutputStream(out);
//    oos.writeObject(origineel);
//    oos.close();
//    byte[] pickled = out.toByteArray();
//    InputStream in = new ByteArrayInputStream(pickled);
//    ObjectInputStream ois = new ObjectInputStream(in);
//    Object o = ois.readObject();
//    Boekentas copy = (Boekentas) o;
//    assertEquals(origineel, copy);
//    assertEquals( KLEUR1, copy.getKleur());
//    assertEquals( VOLUME10, copy.getLaadvolume());
//  }
}

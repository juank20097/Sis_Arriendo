/***********************************************************************
 * Module:  GEN_Articulos.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Articulos
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 67895388-ea28-4d6a-8185-60214a07709a */
public class GEN_Articulos {
   /** @pdOid 2923b17b-d5f4-4530-8f71-e0f5ff0e6677 */
   private Integer art_id;
   /** @pdOid 4f15b7d0-6166-4c2c-b679-62d5f5f73735 */
   private String art_nombre;
   /** @pdOid 9994e5ef-aaf7-4152-bf32-c63118e3b422 */
   private String art_descripcion;
   /** @pdOid f8eb1faf-696d-4a07-a5c1-78d6969afd88 */
   private String art_serial;
   /** @pdOid 2170843a-895c-4dfc-922e-002fb803b5fe */
   private Float art_valor_referenciado;
   /** @pdOid 99c22630-3c62-4889-af80-194f1646b6d3 */
   private char art_estado = 1;
   
   /** @pdOid 7065d49a-c7c7-492e-ad20-c1a269d36e20 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Sitios assc=association1 mult=1..1 side=A */
   public GEN_Sitios sit;
   
   /** @pdOid 6653eee5-bf9b-49ee-8d61-5a874b58ee46 */
   public GEN_Articulos() {
      // TODO: implement
   }
   
   /** @pdOid f63f24f3-9848-403c-b413-132b026511b2 */
   public Integer getArt_id() {
      return art_id;
   }
   
   /** @param newArt_id
    * @pdOid 67c47693-4f66-434c-9079-8678f269c7f3 */
   public void setArt_id(Integer newArt_id) {
      art_id = newArt_id;
   }
   
   /** @pdOid f1981191-ccc1-483d-ac39-cf6cca883939 */
   public String getArt_nombre() {
      return art_nombre;
   }
   
   /** @param newArt_nombre
    * @pdOid eb399574-0778-4bc8-8a4a-11a6720e6696 */
   public void setArt_nombre(String newArt_nombre) {
      art_nombre = newArt_nombre;
   }
   
   /** @pdOid ae5f5ce4-6dc8-4123-8606-8072f82cf6b4 */
   public String getArt_descripcion() {
      return art_descripcion;
   }
   
   /** @param newArt_descripcion
    * @pdOid 4ca5c916-b9dc-42b9-90ad-f52471c0131f */
   public void setArt_descripcion(String newArt_descripcion) {
      art_descripcion = newArt_descripcion;
   }
   
   /** @pdOid 696d2cb7-87ff-46c4-b996-9600a853f6a5 */
   public String getArt_serial() {
      return art_serial;
   }
   
   /** @param newArt_serial
    * @pdOid aedb0484-4a50-42fd-8699-4fa2fa9a5957 */
   public void setArt_serial(String newArt_serial) {
      art_serial = newArt_serial;
   }
   
   /** @pdOid b5e6eb3e-b51b-4f48-8e1d-306d9374b474 */
   public Float getArt_valor_referenciado() {
      return art_valor_referenciado;
   }
   
   /** @param newArt_valor_referenciado
    * @pdOid 1220d79a-6871-4a44-b643-9f764a5a5e1f */
   public void setArt_valor_referenciado(Float newArt_valor_referenciado) {
      art_valor_referenciado = newArt_valor_referenciado;
   }
   
   /** @pdOid abe410a7-c378-4fa3-9762-ccfe5e52b4a7 */
   public char getArt_estado() {
      return art_estado;
   }
   
   /** @param newArt_estado
    * @pdOid 81c8c73f-218a-4b2d-a200-0e63ef1e8a11 */
   public void setArt_estado(char newArt_estado) {
      art_estado = newArt_estado;
   }
   
   
   /** @pdGenerated default parent getter */
   public GEN_Sitios getSit() {
      return sit;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_Sitios */
   public void setSit(GEN_Sitios newGEN_Sitios) {
      if (this.sit == null || !this.sit.equals(newGEN_Sitios))
      {
         if (this.sit != null)
         {
            GEN_Sitios oldGEN_Sitios = this.sit;
            this.sit = null;
            oldGEN_Sitios.removeArt(this);
         }
         if (newGEN_Sitios != null)
         {
            this.sit = newGEN_Sitios;
            this.sit.addArt(this);
         }
      }
   }

}
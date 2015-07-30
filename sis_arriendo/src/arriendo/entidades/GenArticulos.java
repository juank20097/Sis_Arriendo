/***********************************************************************
 * Module:  GenArticulos.java
 * Author:  jestevez
 * Purpose: Defines the Class GenArticulos
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 67895388-ea28-4d6a-8185-60214a07709a */
public class GenArticulos {
   /** @pdOid 2923b17b-d5f4-4530-8f71-e0f5ff0e6677 */
   private Integer artId;
   /** @pdOid 4f15b7d0-6166-4c2c-b679-62d5f5f73735 */
   private String artNombre;
   /** @pdOid 9994e5ef-aaf7-4152-bf32-c63118e3b422 */
   private String artDescripcion;
   /** @pdOid f8eb1faf-696d-4a07-a5c1-78d6969afd88 */
   private String artSerial;
   /** @pdOid 2170843a-895c-4dfc-922e-002fb803b5fe */
   private Float artValorReferenciado;
   /** @pdOid 99c22630-3c62-4889-af80-194f1646b6d3 */
   private char artEstado = 1;
   
   /** @pdOid 7065d49a-c7c7-492e-ad20-c1a269d36e20 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GenSitios assc=association1 mult=1..1 side=A */
   public GenSitios sit;
   
   /** @pdOid 6653eee5-bf9b-49ee-8d61-5a874b58ee46 */
   public GenArticulos() {
      // TODO: implement
   }
   
   /** @pdOid f63f24f3-9848-403c-b413-132b026511b2 */
   public Integer getArtId() {
      return artId;
   }
   
   /** @param newArtId
    * @pdOid 67c47693-4f66-434c-9079-8678f269c7f3 */
   public void setArtId(Integer newArtId) {
      artId = newArtId;
   }
   
   /** @pdOid f1981191-ccc1-483d-ac39-cf6cca883939 */
   public String getArtNombre() {
      return artNombre;
   }
   
   /** @param newArtNombre
    * @pdOid eb399574-0778-4bc8-8a4a-11a6720e6696 */
   public void setArtNombre(String newArtNombre) {
      artNombre = newArtNombre;
   }
   
   /** @pdOid ae5f5ce4-6dc8-4123-8606-8072f82cf6b4 */
   public String getArtDescripcion() {
      return artDescripcion;
   }
   
   /** @param newArtDescripcion
    * @pdOid 4ca5c916-b9dc-42b9-90ad-f52471c0131f */
   public void setArtDescripcion(String newArtDescripcion) {
      artDescripcion = newArtDescripcion;
   }
   
   /** @pdOid 696d2cb7-87ff-46c4-b996-9600a853f6a5 */
   public String getArtSerial() {
      return artSerial;
   }
   
   /** @param newArtSerial
    * @pdOid aedb0484-4a50-42fd-8699-4fa2fa9a5957 */
   public void setArtSerial(String newArtSerial) {
      artSerial = newArtSerial;
   }
   
   /** @pdOid b5e6eb3e-b51b-4f48-8e1d-306d9374b474 */
   public Float getArtValorReferenciado() {
      return artValorReferenciado;
   }
   
   /** @param newArtValorReferenciado
    * @pdOid 1220d79a-6871-4a44-b643-9f764a5a5e1f */
   public void setArtValorReferenciado(Float newArtValorReferenciado) {
      artValorReferenciado = newArtValorReferenciado;
   }
   
   /** @pdOid abe410a7-c378-4fa3-9762-ccfe5e52b4a7 */
   public char getArtEstado() {
      return artEstado;
   }
   
   /** @param newArtEstado
    * @pdOid 81c8c73f-218a-4b2d-a200-0e63ef1e8a11 */
   public void setArtEstado(char newArtEstado) {
      artEstado = newArtEstado;
   }

}
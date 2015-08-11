/***********************************************************************
 * Module:  Gen_Tsitios.java
 * Author:  jestevez
 * Purpose: Defines the Class Gen_Tsitios
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 38963448-3c76-4978-8111-2c79e04dc30f */
public class Gen_Tsitios {
   /** @pdOid cedbc451-77af-42ab-955f-0d158f6acc0b */
   private Integer tsi_id;
   /** @pdOid 38e905ae-d6b8-4a77-ada0-149674dfac1f */
   private String tsi_nombre;
   /** @pdOid af6dc671-b0ac-42c1-bf09-d174c6ff9158 */
   private String tsi_descripcion;
   /** @pdOid 412ee3e1-f15d-4902-bdfd-52e930c2aa47 */
   private char tsi_estado;
   
   /** @pdOid b321cb94-91f4-4b7e-aec6-89147a04df2d */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Sitios assc=association17 coll=java.util.List mult=* */
   public java.util.List<GEN_Sitios> sit;
   
   /** @pdOid f0f329aa-e123-458e-ace6-f12ac2ccdec5 */
   public Gen_Tsitios() {
      // TODO: implement
   }
   
   /** @pdOid c680ca90-009a-46b9-a44a-2d94d7b07749 */
   public Integer getTsi_id() {
      return tsi_id;
   }
   
   /** @param newTsi_id
    * @pdOid 1320b457-9aed-4215-aa28-18eb57c4cc33 */
   public void setTsi_id(Integer newTsi_id) {
      tsi_id = newTsi_id;
   }
   
   /** @pdOid 3c4bb5cb-8b59-42b0-bbb0-3f01b19c3f6b */
   public String getTsi_nombre() {
      return tsi_nombre;
   }
   
   /** @param newTsi_nombre
    * @pdOid ff3c02c3-3525-46f5-b836-6a325253576f */
   public void setTsi_nombre(String newTsi_nombre) {
      tsi_nombre = newTsi_nombre;
   }
   
   /** @pdOid d410be49-8037-4441-a243-30225d38cb5c */
   public String getTsi_descripcion() {
      return tsi_descripcion;
   }
   
   /** @param newTsi_descripcion
    * @pdOid cc90a642-f430-4eff-862e-a0b37015c105 */
   public void setTsi_descripcion(String newTsi_descripcion) {
      tsi_descripcion = newTsi_descripcion;
   }
   
   /** @pdOid 8f7c92c7-a371-40ff-aa9f-2502fcbe36ea */
   public char getTsi_estado() {
      return tsi_estado;
   }
   
   /** @param newTsi_estado
    * @pdOid 73209d10-3b12-4411-907b-30f9781fd75f */
   public void setTsi_estado(char newTsi_estado) {
      tsi_estado = newTsi_estado;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GEN_Sitios> getSit() {
      if (sit == null)
         sit = new java.util.Vector<GEN_Sitios>();
      return sit;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSit() {
      if (sit == null)
         sit = new java.util.Vector<GEN_Sitios>();
      return sit.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSit */
   public void setSit(java.util.List<GEN_Sitios> newSit) {
      removeAllSit();
      for (java.util.Iterator iter = newSit.iterator(); iter.hasNext();)
         addSit((GEN_Sitios)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGEN_Sitios */
   public void addSit(GEN_Sitios newGEN_Sitios) {
      if (newGEN_Sitios == null)
         return;
      if (this.sit == null)
         this.sit = new java.util.Vector<GEN_Sitios>();
      if (!this.sit.contains(newGEN_Sitios))
      {
         this.sit.add(newGEN_Sitios);
         newGEN_Sitios.setTsi(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGEN_Sitios */
   public void removeSit(GEN_Sitios oldGEN_Sitios) {
      if (oldGEN_Sitios == null)
         return;
      if (this.sit != null)
         if (this.sit.contains(oldGEN_Sitios))
         {
            this.sit.remove(oldGEN_Sitios);
            oldGEN_Sitios.setTsi((Gen_Tsitios)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSit() {
      if (sit != null)
      {
         GEN_Sitios oldGEN_Sitios;
         for (java.util.Iterator iter = getIteratorSit(); iter.hasNext();)
         {
            oldGEN_Sitios = (GEN_Sitios)iter.next();
            iter.remove();
            oldGEN_Sitios.setTsi((Gen_Tsitios)null);
         }
      }
   }

}
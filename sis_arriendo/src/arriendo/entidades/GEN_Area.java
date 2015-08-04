/***********************************************************************
 * Module:  GEN_Area.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Area
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid feb47f28-54d1-446b-aa0e-a04653b54fc5 */
public class GEN_Area {
   /** @pdOid bca0ef32-e545-4668-b1ac-ece2f37e1df1 */
   private Integer are_id;
   /** @pdOid 832bf661-039d-431b-8dda-21478b6a4890 */
   private String are_nombre;
   /** @pdOid d51e55e0-d8c0-4c76-b3a2-5079b58e24cc */
   private String are_ubicacion;
   /** @pdOid 524ac92d-59a3-4ba8-b5da-f2cdfeac3574 */
   private String are_descripcion;
   /** @pdOid f1250a3c-63d1-478e-9548-97d3d39d2af2 */
   private char are_estado = 1;
   
   /** @pdOid a94e10fb-0724-4925-8d59-cb497188dff2 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Sitios assc=association9 coll=java.util.List mult=* */
   public java.util.List<GEN_Sitios> sit;
   /** @pdRoleInfo migr=no name=GEN_Sector assc=association16 mult=1..1 side=A */
   public GEN_Sector sec;
   
   /** @pdOid 01a3275a-097c-497b-b810-930470fcf9c6 */
   public GEN_Area() {
      // TODO: implement
   }
   
   /** @pdOid f3227e72-7550-4685-960c-1c5b320e0569 */
   public Integer getAre_id() {
      return are_id;
   }
   
   /** @param newAre_id
    * @pdOid 87765521-f605-45a7-893d-68cfd640270a */
   public void setAre_id(Integer newAre_id) {
      are_id = newAre_id;
   }
   
   /** @pdOid 8e09f10a-2619-447f-bafc-470e7fb6d444 */
   public String getAre_nombre() {
      return are_nombre;
   }
   
   /** @param newAre_nombre
    * @pdOid 0b4e04e8-b028-4f9b-97d1-9caf16c171be */
   public void setAre_nombre(String newAre_nombre) {
      are_nombre = newAre_nombre;
   }
   
   /** @pdOid 9294bbc2-0ac1-49a9-bb5d-e3c90891d15c */
   public String getAre_ubicacion() {
      return are_ubicacion;
   }
   
   /** @param newAre_ubicacion
    * @pdOid ec327a2f-37a6-4f52-96d8-46c9de3d68c7 */
   public void setAre_ubicacion(String newAre_ubicacion) {
      are_ubicacion = newAre_ubicacion;
   }
   
   /** @pdOid 32a8247d-8088-4056-9a64-385955bc5332 */
   public String getAre_descripcion() {
      return are_descripcion;
   }
   
   /** @param newAre_descripcion
    * @pdOid 0c21884f-d4e2-49bd-8434-d5c95e4f93f9 */
   public void setAre_descripcion(String newAre_descripcion) {
      are_descripcion = newAre_descripcion;
   }
   
   /** @pdOid c75347a6-d217-46a8-bd9d-4469e96d67be */
   public char getAre_estado() {
      return are_estado;
   }
   
   /** @param newAre_estado
    * @pdOid 3825dcf5-a3dc-429b-98a7-92a0d2354802 */
   public void setAre_estado(char newAre_estado) {
      are_estado = newAre_estado;
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
         newGEN_Sitios.setAre(this);      
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
            oldGEN_Sitios.setAre((GEN_Area)null);
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
            oldGEN_Sitios.setAre((GEN_Area)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public GEN_Sector getSec() {
      return sec;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_Sector */
   public void setSec(GEN_Sector newGEN_Sector) {
      if (this.sec == null || !this.sec.equals(newGEN_Sector))
      {
         if (this.sec != null)
         {
            GEN_Sector oldGEN_Sector = this.sec;
            this.sec = null;
            oldGEN_Sector.removeAre(this);
         }
         if (newGEN_Sector != null)
         {
            this.sec = newGEN_Sector;
            this.sec.addAre(this);
         }
      }
   }

}
/***********************************************************************
 * Module:  GenArea.java
 * Author:  jestevez
 * Purpose: Defines the Class GenArea
 ***********************************************************************/

package arriendo.Entidades;

import java.util.*;

/** @pdOid feb47f28-54d1-446b-aa0e-a04653b54fc5 */
public class GenArea {
   /** @pdOid bca0ef32-e545-4668-b1ac-ece2f37e1df1 */
   private Integer areId;
   /** @pdOid 832bf661-039d-431b-8dda-21478b6a4890 */
   private String areNombre;
   /** @pdOid d51e55e0-d8c0-4c76-b3a2-5079b58e24cc */
   private String areUbicacion;
   /** @pdOid 524ac92d-59a3-4ba8-b5da-f2cdfeac3574 */
   private String areDescripcion;
   /** @pdOid f1250a3c-63d1-478e-9548-97d3d39d2af2 */
   private char areEstado = 1;
   
   /** @pdOid a94e10fb-0724-4925-8d59-cb497188dff2 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GenSitios assc=association9 coll=java.util.List mult=* */
   public java.util.List<GenSitios> sit;
   
   /** @pdOid 01a3275a-097c-497b-b810-930470fcf9c6 */
   public GenArea() {
      // TODO: implement
   }
   
   /** @pdOid f3227e72-7550-4685-960c-1c5b320e0569 */
   public Integer getAreId() {
      return areId;
   }
   
   /** @param newAreId
    * @pdOid 87765521-f605-45a7-893d-68cfd640270a */
   public void setAreId(Integer newAreId) {
      areId = newAreId;
   }
   
   /** @pdOid 8e09f10a-2619-447f-bafc-470e7fb6d444 */
   public String getAreNombre() {
      return areNombre;
   }
   
   /** @param newAreNombre
    * @pdOid 0b4e04e8-b028-4f9b-97d1-9caf16c171be */
   public void setAreNombre(String newAreNombre) {
      areNombre = newAreNombre;
   }
   
   /** @pdOid 9294bbc2-0ac1-49a9-bb5d-e3c90891d15c */
   public String getAreUbicacion() {
      return areUbicacion;
   }
   
   /** @param newAreUbicacion
    * @pdOid ec327a2f-37a6-4f52-96d8-46c9de3d68c7 */
   public void setAreUbicacion(String newAreUbicacion) {
      areUbicacion = newAreUbicacion;
   }
   
   /** @pdOid 32a8247d-8088-4056-9a64-385955bc5332 */
   public String getAreDescripcion() {
      return areDescripcion;
   }
   
   /** @param newAreDescripcion
    * @pdOid 0c21884f-d4e2-49bd-8434-d5c95e4f93f9 */
   public void setAreDescripcion(String newAreDescripcion) {
      areDescripcion = newAreDescripcion;
   }
   
   /** @pdOid c75347a6-d217-46a8-bd9d-4469e96d67be */
   public char getAreEstado() {
      return areEstado;
   }
   
   /** @param newAreEstado
    * @pdOid 3825dcf5-a3dc-429b-98a7-92a0d2354802 */
   public void setAreEstado(char newAreEstado) {
      areEstado = newAreEstado;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GenSitios> getSit() {
      if (sit == null)
         sit = new java.util.Vector<GenSitios>();
      return sit;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSit() {
      if (sit == null)
         sit = new java.util.Vector<GenSitios>();
      return sit.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSit */
   public void setSit(java.util.List<GenSitios> newSit) {
      removeAllSit();
      for (java.util.Iterator iter = newSit.iterator(); iter.hasNext();)
         addSit((GenSitios)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGenSitios */
   public void addSit(GenSitios newGenSitios) {
      if (newGenSitios == null)
         return;
      if (this.sit == null)
         this.sit = new java.util.Vector<GenSitios>();
      if (!this.sit.contains(newGenSitios))
      {
         this.sit.add(newGenSitios);
         newGenSitios.setAre(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGenSitios */
   public void removeSit(GenSitios oldGenSitios) {
      if (oldGenSitios == null)
         return;
      if (this.sit != null)
         if (this.sit.contains(oldGenSitios))
         {
            this.sit.remove(oldGenSitios);
            oldGenSitios.setAre((GenArea)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSit() {
      if (sit != null)
      {
         GenSitios oldGenSitios;
         for (java.util.Iterator iter = getIteratorSit(); iter.hasNext();)
         {
            oldGenSitios = (GenSitios)iter.next();
            iter.remove();
            oldGenSitios.setAre((GenArea)null);
         }
      }
   }

}
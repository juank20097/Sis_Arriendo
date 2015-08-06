/***********************************************************************
 * Module:  GEN_Institucion.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Institucion
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 4b4d2594-ed14-473d-b0d3-c06e902990ed */
public class GEN_Institucion {
   /** @pdOid 4088a318-34be-47b5-bc6b-50d0dc7f14da */
   private Integer ins_id;
   /** @pdOid 17e23e67-e871-431b-9692-1577cbfe9837 */
   private String ins_nombre;
   /** @pdOid fcd64f7a-6296-4826-92d2-d5191b22a619 */
   private String ins_descripcion;
   /** @pdOid 71535b28-d92d-405e-8cfb-8c3fdbd9eb4b */
   private Integer ins_estado;
   
   /** @pdOid 728515e6-8ba8-4cbb-a0de-5df6ddcb5b8c */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Sector assc=association15 coll=java.util.List mult=* */
   public java.util.List<GEN_Sector> sec;
   
   /** @pdOid 23269cfd-0aa0-49cd-b50b-fa2c2f6565e7 */
   public GEN_Institucion() {
      // TODO: implement
   }
   
   /** @pdOid 529a24b1-325b-4314-8404-d91d9603243f */
   public Integer getIns_id() {
      return ins_id;
   }
   
   /** @param newIns_id
    * @pdOid 699a250f-0472-48ec-9ee2-2e188ea14f3e */
   public void setIns_id(Integer newIns_id) {
      ins_id = newIns_id;
   }
   
   /** @pdOid 08a3fc82-8fac-4627-b9c7-2bba7e45614b */
   public String getIns_nombre() {
      return ins_nombre;
   }
   
   /** @param newIns_nombre
    * @pdOid 1b7a93c5-ed61-41dc-8e4d-be256b322cfe */
   public void setIns_nombre(String newIns_nombre) {
      ins_nombre = newIns_nombre;
   }
   
   /** @pdOid 8cb2456f-07eb-44b4-8874-10a8d0191dcb */
   public String getIns_descripcion() {
      return ins_descripcion;
   }
   
   /** @param newIns_descripcion
    * @pdOid d275fe0f-93fe-4e38-9ce7-650a2b88d2c3 */
   public void setIns_descripcion(String newIns_descripcion) {
      ins_descripcion = newIns_descripcion;
   }
   
   /** @pdOid bf5be058-ee33-4d9a-b3e7-454eafaca5b1 */
   public Integer getIns_estado() {
      return ins_estado;
   }
   
   /** @param newIns_estado
    * @pdOid be5949dd-21cc-472c-b7b6-147deddbd9c1 */
   public void setIns_estado(Integer newIns_estado) {
      ins_estado = newIns_estado;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GEN_Sector> getSec() {
      if (sec == null)
         sec = new java.util.Vector<GEN_Sector>();
      return sec;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSec() {
      if (sec == null)
         sec = new java.util.Vector<GEN_Sector>();
      return sec.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSec */
   public void setSec(java.util.List<GEN_Sector> newSec) {
      removeAllSec();
      for (java.util.Iterator iter = newSec.iterator(); iter.hasNext();)
         addSec((GEN_Sector)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGEN_Sector */
   public void addSec(GEN_Sector newGEN_Sector) {
      if (newGEN_Sector == null)
         return;
      if (this.sec == null)
         this.sec = new java.util.Vector<GEN_Sector>();
      if (!this.sec.contains(newGEN_Sector))
      {
         this.sec.add(newGEN_Sector);
         newGEN_Sector.setIns(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGEN_Sector */
   public void removeSec(GEN_Sector oldGEN_Sector) {
      if (oldGEN_Sector == null)
         return;
      if (this.sec != null)
         if (this.sec.contains(oldGEN_Sector))
         {
            this.sec.remove(oldGEN_Sector);
            oldGEN_Sector.setIns((GEN_Institucion)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSec() {
      if (sec != null)
      {
         GEN_Sector oldGEN_Sector;
         for (java.util.Iterator iter = getIteratorSec(); iter.hasNext();)
         {
            oldGEN_Sector = (GEN_Sector)iter.next();
            iter.remove();
            oldGEN_Sector.setIns((GEN_Institucion)null);
         }
      }
   }

}
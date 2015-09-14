/***********************************************************************
 * Module:  ARR_Contratos_Det.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_Contratos_Det
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid ea091c16-1e8f-477b-8755-14092db8eca4 */
public class ARR_Contratos_Det {
   /** @pdOid 0b9fc25a-4805-478b-80b9-93fd5117addb */
   private Integer det_id;
   /** @pdOid f5b57b0c-701e-4ec4-b121-5750f04b0f2b */
   private String det_observacion;
   /** @pdOid 8df9fec3-5a7a-4885-b0d8-7a7a1ad171fe */
   private Float det_costo;
   /** @pdOid 130743f5-3ae3-405f-891b-f5000f771b56 */
   private char det_estado;
   
   /** @pdOid 7043e8c9-7c34-4c29-b8a0-b417f2d8feeb */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Sitios assc=association2 mult=1..1 side=A */
   public GEN_Sitios sit;
   /** @pdRoleInfo migr=no name=ARR_Contratos_Cab assc=association3 mult=1..1 side=A */
   public ARR_Contratos_Cab con_cab;
   /** @pdRoleInfo migr=no name=ARR_ContratoArticulos assc=association14 coll=java.util.List mult=* side=A */
   public java.util.List<ARR_ContratoArticulos> con_art;
   
   /** @pdOid 269aff93-3eb8-4dda-bf79-b41953985d98 */
   public ARR_Contratos_Det() {
      // TODO: implement
   }
   
   /** @pdOid 0e62b5dd-b2ca-4880-952f-206be44b7630 */
   public Integer getDet_id() {
      return det_id;
   }
   
   /** @param newDet_id
    * @pdOid a1381c37-40ac-48af-a1ad-94be4d1b698f */
   public void setDet_id(Integer newDet_id) {
      det_id = newDet_id;
   }
   
   /** @pdOid 56a840bf-9cb6-4803-9726-877a2c122ed8 */
   public String getDet_observacion() {
      return det_observacion;
   }
   
   /** @param newDet_observacion
    * @pdOid b8defaf2-c318-453e-8e98-ff27094b9f6e */
   public void setDet_observacion(String newDet_observacion) {
      det_observacion = newDet_observacion;
   }
   
   /** @pdOid a7c8b6cb-3b47-47e3-929c-948079480d8c */
   public Float getDet_costo() {
      return det_costo;
   }
   
   /** @param newDet_costo
    * @pdOid 79c9c133-d51e-4a22-821f-58e99a2fdc20 */
   public void setDet_costo(Float newDet_costo) {
      det_costo = newDet_costo;
   }
   
   /** @pdOid 08f7af01-2734-45ce-bd96-c841c1690e7b */
   public char getDet_estado() {
      return det_estado;
   }
   
   /** @param newDet_estado
    * @pdOid 08b42bdf-68e6-49c9-a0dd-a32f0102dc5d */
   public void setDet_estado(char newDet_estado) {
      det_estado = newDet_estado;
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
        /* if (this.sit != null)
         {
            GEN_Sitios oldGEN_Sitios = this.sit;
            this.sit = null;
            oldGEN_Sitios.removeCon_det(this);
         } */
         if (newGEN_Sitios != null)
         {
            this.sit = newGEN_Sitios;
            this.sit.addCon_det(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public ARR_Contratos_Cab getCon_cab() {
      return con_cab;
   }
   
   /** @pdGenerated default parent setter
     * @param newARR_Contratos_Cab */
   public void setCon_cab(ARR_Contratos_Cab newARR_Contratos_Cab) {
      if (this.con_cab == null || !this.con_cab.equals(newARR_Contratos_Cab))
      {
        /* if (this.con_cab != null)
         {
            ARR_Contratos_Cab oldARR_Contratos_Cab = this.con_cab;
            this.con_cab = null;
            oldARR_Contratos_Cab.removeCon_det(this);
         } */
         if (newARR_Contratos_Cab != null)
         {
            this.con_cab = newARR_Contratos_Cab;
            this.con_cab.addCon_det(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ARR_ContratoArticulos> getCon_art() {
      if (con_art == null)
         con_art = new java.util.Vector<ARR_ContratoArticulos>();
      return con_art;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCon_art() {
      if (con_art == null)
         con_art = new java.util.Vector<ARR_ContratoArticulos>();
      return con_art.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCon_art */
   public void setCon_art(java.util.List<ARR_ContratoArticulos> newCon_art) {
      removeAllCon_art();
      for (java.util.Iterator iter = newCon_art.iterator(); iter.hasNext();)
         addCon_art((ARR_ContratoArticulos)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_ContratoArticulos */
   public void addCon_art(ARR_ContratoArticulos newARR_ContratoArticulos) {
      if (newARR_ContratoArticulos == null)
         return;
      if (this.con_art == null)
         this.con_art = new java.util.Vector<ARR_ContratoArticulos>();
      if (!this.con_art.contains(newARR_ContratoArticulos))
      {
         this.con_art.add(newARR_ContratoArticulos);
         newARR_ContratoArticulos.setCon_det(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_ContratoArticulos */
   public void removeCon_art(ARR_ContratoArticulos oldARR_ContratoArticulos) {
      if (oldARR_ContratoArticulos == null)
         return;
      if (this.con_art != null)
         if (this.con_art.contains(oldARR_ContratoArticulos))
         {
            this.con_art.remove(oldARR_ContratoArticulos);
            oldARR_ContratoArticulos.setCon_det((ARR_Contratos_Det)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCon_art() {
      if (con_art != null)
      {
         ARR_ContratoArticulos oldARR_ContratoArticulos;
         for (java.util.Iterator iter = getIteratorCon_art(); iter.hasNext();)
         {
            oldARR_ContratoArticulos = (ARR_ContratoArticulos)iter.next();
            iter.remove();
            oldARR_ContratoArticulos.setCon_det((ARR_Contratos_Det)null);
         }
      }
   }

}
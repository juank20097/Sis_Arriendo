/***********************************************************************
 * Module:  ARR_Contratos_Cab.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_Contratos_Cab
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 23bdef8f-3661-4629-89ca-695fd3eb0632 */
public class ARR_Contratos_Cab {
   /** @pdOid 9350c158-f713-4124-8d8e-1ef168c4e8d6 */
   private Integer cab_id;
   /** @pdOid a5e2bf76-04b0-487b-8119-5b833a2e1c2b */
   private Date cab_fecha;
   /** @pdOid 2011fad8-07c0-4816-8333-3bb0f223bb30 */
   private Date cab_fechaini;
   /** @pdOid cd75a98b-0a58-4fff-90ae-b6a92ae5cd6a */
   private Date cab_fechafin;
   /** @pdOid d0951824-ac27-4109-9313-2cb1f0ffea0b */
   private String cab_observacion;
   /** @pdOid 6a206325-7732-476c-bd31-099df6e118c1 */
   private char cab_estado;
   
   /** @pdOid 8675dc8e-a9a3-4a42-b43c-c30e8edb1199 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Contratos_Det assc=association3 coll=java.util.List mult=* */
   public java.util.List<ARR_Contratos_Det> con_det;
   /** @pdRoleInfo migr=no name=ARR_ContratoClausulas_Det assc=association13 coll=java.util.List mult=* */
   public java.util.List<ARR_ContratoClausulas_Det> con_cla_d;
   /** @pdRoleInfo migr=no name=ARR_Inter_Per assc=association10 coll=java.util.List mult=* side=A */
   public java.util.List<ARR_Inter_Per> intp;
   
   /** @pdOid a592bcbc-56fc-40f0-b355-0d9189a9d338 */
   public ARR_Contratos_Cab() {
      // TODO: implement
   }
   
   /** @pdOid f42fd7eb-b530-4646-b5fb-1c19fdd45677 */
   public Integer getCab_id() {
      return cab_id;
   }
   
   /** @param newCab_id
    * @pdOid 7a41a29a-5178-4131-8ac6-a3ad1ad97f6d */
   public void setCab_id(Integer newCab_id) {
      cab_id = newCab_id;
   }
   
   /** @pdOid 6476c5a2-bbdc-488e-8fb5-ed124793db38 */
   public Date getCab_fecha() {
      return cab_fecha;
   }
   
   /** @param newCab_fecha
    * @pdOid 3b18e91c-0d0b-477d-a21f-07dc32bb0e5a */
   public void setCab_fecha(Date newCab_fecha) {
      cab_fecha = newCab_fecha;
   }
   
   /** @pdOid 8b218ebc-e11b-4363-8b82-86d4bd739719 */
   public Date getCab_fechaini() {
      return cab_fechaini;
   }
   
   /** @param newCab_fechaini
    * @pdOid fea934d4-f45a-4581-8072-2923171f7c45 */
   public void setCab_fechaini(Date newCab_fechaini) {
      cab_fechaini = newCab_fechaini;
   }
   
   /** @pdOid de07ab52-4bd3-494a-b1b6-b8cb0f1d9bed */
   public Date getCab_fechafin() {
      return cab_fechafin;
   }
   
   /** @param newCab_fechafin
    * @pdOid cb96193a-eedc-45ae-bf73-9d3b174b4421 */
   public void setCab_fechafin(Date newCab_fechafin) {
      cab_fechafin = newCab_fechafin;
   }
   
   /** @pdOid 8cab54dc-f9a1-497c-b009-6e2c73398630 */
   public String getCab_observacion() {
      return cab_observacion;
   }
   
   /** @param newCab_observacion
    * @pdOid 8eafadb2-a838-42f9-85e4-fb69d18b00f9 */
   public void setCab_observacion(String newCab_observacion) {
      cab_observacion = newCab_observacion;
   }
   
   /** @pdOid 5101e6d5-ab61-4edd-8e0a-6b8740958e95 */
   public char getCab_estado() {
      return cab_estado;
   }
   
   /** @param newCab_estado
    * @pdOid e0669d7b-9397-4553-be80-92b8654ee383 */
   public void setCab_estado(char newCab_estado) {
      cab_estado = newCab_estado;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<ARR_Contratos_Det> getCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ARR_Contratos_Det>();
      return con_det;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ARR_Contratos_Det>();
      return con_det.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCon_det */
   public void setCon_det(java.util.List<ARR_Contratos_Det> newCon_det) {
      removeAllCon_det();
      for (java.util.Iterator iter = newCon_det.iterator(); iter.hasNext();)
         addCon_det((ARR_Contratos_Det)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_Contratos_Det */
   public void addCon_det(ARR_Contratos_Det newARR_Contratos_Det) {
      if (newARR_Contratos_Det == null)
         return;
      if (this.con_det == null)
         this.con_det = new java.util.Vector<ARR_Contratos_Det>();
      if (!this.con_det.contains(newARR_Contratos_Det))
      {
         this.con_det.add(newARR_Contratos_Det);
         newARR_Contratos_Det.setCon_cab(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_Contratos_Det */
   public void removeCon_det(ARR_Contratos_Det oldARR_Contratos_Det) {
      if (oldARR_Contratos_Det == null)
         return;
      if (this.con_det != null)
         if (this.con_det.contains(oldARR_Contratos_Det))
         {
            this.con_det.remove(oldARR_Contratos_Det);
            oldARR_Contratos_Det.setCon_cab((ARR_Contratos_Cab)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCon_det() {
      if (con_det != null)
      {
         ARR_Contratos_Det oldARR_Contratos_Det;
         for (java.util.Iterator iter = getIteratorCon_det(); iter.hasNext();)
         {
            oldARR_Contratos_Det = (ARR_Contratos_Det)iter.next();
            iter.remove();
            oldARR_Contratos_Det.setCon_cab((ARR_Contratos_Cab)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ARR_ContratoClausulas_Det> getCon_cla_d() {
      if (con_cla_d == null)
         con_cla_d = new java.util.Vector<ARR_ContratoClausulas_Det>();
      return con_cla_d;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCon_cla_d() {
      if (con_cla_d == null)
         con_cla_d = new java.util.Vector<ARR_ContratoClausulas_Det>();
      return con_cla_d.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCon_cla_d */
   public void setCon_cla_d(java.util.List<ARR_ContratoClausulas_Det> newCon_cla_d) {
      removeAllCon_cla_d();
      for (java.util.Iterator iter = newCon_cla_d.iterator(); iter.hasNext();)
         addCon_cla_d((ARR_ContratoClausulas_Det)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_ContratoClausulas_Det */
   public void addCon_cla_d(ARR_ContratoClausulas_Det newARR_ContratoClausulas_Det) {
      if (newARR_ContratoClausulas_Det == null)
         return;
      if (this.con_cla_d == null)
         this.con_cla_d = new java.util.Vector<ARR_ContratoClausulas_Det>();
      if (!this.con_cla_d.contains(newARR_ContratoClausulas_Det))
      {
         this.con_cla_d.add(newARR_ContratoClausulas_Det);
         newARR_ContratoClausulas_Det.setCon_cab(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_ContratoClausulas_Det */
   public void removeCon_cla_d(ARR_ContratoClausulas_Det oldARR_ContratoClausulas_Det) {
      if (oldARR_ContratoClausulas_Det == null)
         return;
      if (this.con_cla_d != null)
         if (this.con_cla_d.contains(oldARR_ContratoClausulas_Det))
         {
            this.con_cla_d.remove(oldARR_ContratoClausulas_Det);
            oldARR_ContratoClausulas_Det.setCon_cab((ARR_Contratos_Cab)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCon_cla_d() {
      if (con_cla_d != null)
      {
         ARR_ContratoClausulas_Det oldARR_ContratoClausulas_Det;
         for (java.util.Iterator iter = getIteratorCon_cla_d(); iter.hasNext();)
         {
            oldARR_ContratoClausulas_Det = (ARR_ContratoClausulas_Det)iter.next();
            iter.remove();
            oldARR_ContratoClausulas_Det.setCon_cab((ARR_Contratos_Cab)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ARR_Inter_Per> getIntp() {
      if (intp == null)
         intp = new java.util.Vector<ARR_Inter_Per>();
      return intp;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIntp() {
      if (intp == null)
         intp = new java.util.Vector<ARR_Inter_Per>();
      return intp.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIntp */
   public void setIntp(java.util.List<ARR_Inter_Per> newIntp) {
      removeAllIntp();
      for (java.util.Iterator iter = newIntp.iterator(); iter.hasNext();)
         addIntp((ARR_Inter_Per)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_Inter_Per */
   public void addIntp(ARR_Inter_Per newARR_Inter_Per) {
      if (newARR_Inter_Per == null)
         return;
      if (this.intp == null)
         this.intp = new java.util.Vector<ARR_Inter_Per>();
      if (!this.intp.contains(newARR_Inter_Per))
      {
         this.intp.add(newARR_Inter_Per);
         newARR_Inter_Per.setCon_cab(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_Inter_Per */
   public void removeIntp(ARR_Inter_Per oldARR_Inter_Per) {
      if (oldARR_Inter_Per == null)
         return;
      if (this.intp != null)
         if (this.intp.contains(oldARR_Inter_Per))
         {
            this.intp.remove(oldARR_Inter_Per);
            oldARR_Inter_Per.setCon_cab((ARR_Contratos_Cab)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIntp() {
      if (intp != null)
      {
         ARR_Inter_Per oldARR_Inter_Per;
         for (java.util.Iterator iter = getIteratorIntp(); iter.hasNext();)
         {
            oldARR_Inter_Per = (ARR_Inter_Per)iter.next();
            iter.remove();
            oldARR_Inter_Per.setCon_cab((ARR_Contratos_Cab)null);
         }
      }
   }

}
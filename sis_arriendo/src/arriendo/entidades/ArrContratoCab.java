/***********************************************************************
 * Module:  ArrContratoCab.java
 * Author:  jestevez
 * Purpose: Defines the Class ArrContratoCab
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 23bdef8f-3661-4629-89ca-695fd3eb0632 */
public class ArrContratoCab {
   /** @pdOid 9350c158-f713-4124-8d8e-1ef168c4e8d6 */
   private Integer cabId;
   /** @pdOid a5e2bf76-04b0-487b-8119-5b833a2e1c2b */
   private Date cabFecha;
   /** @pdOid 2011fad8-07c0-4816-8333-3bb0f223bb30 */
   private Date cabFechaini;
   /** @pdOid cd75a98b-0a58-4fff-90ae-b6a92ae5cd6a */
   private Date cabFechafin;
   /** @pdOid aa2c8ebd-56e7-4691-9c34-0801c63ae611 */
   private String cabArrendatario;
   /** @pdOid 429aeacc-ae7f-42c0-93e7-e4cb36ba6441 */
   private String cabArrendador;
   /** @pdOid d0951824-ac27-4109-9313-2cb1f0ffea0b */
   private String cabObservacion;
   /** @pdOid 6a206325-7732-476c-bd31-099df6e118c1 */
   private char cabEstado = 1;
   
   /** @pdOid 8675dc8e-a9a3-4a42-b43c-c30e8edb1199 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ArrContratoDet assc=association3 coll=java.util.List mult=* */
   public java.util.List<ArrContratoDet> con_det;
   /** @pdRoleInfo migr=no name=ArrInter assc=association4 coll=java.util.List mult=* */
   public java.util.List<ArrInter> intc;
   /** @pdRoleInfo migr=no name=ArrInterPer assc=association10 coll=java.util.List mult=* side=A */
   public java.util.List<ArrInterPer> intp;
   
   /** @pdOid a592bcbc-56fc-40f0-b355-0d9189a9d338 */
   public ArrContratoCab() {
      // TODO: implement
   }
   
   /** @pdOid f42fd7eb-b530-4646-b5fb-1c19fdd45677 */
   public Integer getCabId() {
      return cabId;
   }
   
   /** @param newCabId
    * @pdOid 7a41a29a-5178-4131-8ac6-a3ad1ad97f6d */
   public void setCabId(Integer newCabId) {
      cabId = newCabId;
   }
   
   /** @pdOid 6476c5a2-bbdc-488e-8fb5-ed124793db38 */
   public Date getCabFecha() {
      return cabFecha;
   }
   
   /** @param newCabFecha
    * @pdOid 3b18e91c-0d0b-477d-a21f-07dc32bb0e5a */
   public void setCabFecha(Date newCabFecha) {
      cabFecha = newCabFecha;
   }
   
   /** @pdOid 8b218ebc-e11b-4363-8b82-86d4bd739719 */
   public Date getCabFechaini() {
      return cabFechaini;
   }
   
   /** @param newCabFechaini
    * @pdOid fea934d4-f45a-4581-8072-2923171f7c45 */
   public void setCabFechaini(Date newCabFechaini) {
      cabFechaini = newCabFechaini;
   }
   
   /** @pdOid de07ab52-4bd3-494a-b1b6-b8cb0f1d9bed */
   public Date getCabFechafin() {
      return cabFechafin;
   }
   
   /** @param newCabFechafin
    * @pdOid cb96193a-eedc-45ae-bf73-9d3b174b4421 */
   public void setCabFechafin(Date newCabFechafin) {
      cabFechafin = newCabFechafin;
   }
   
   /** @pdOid 481477a5-57de-42d0-a12a-a6eff6525276 */
   public String getCabArrendatario() {
      return cabArrendatario;
   }
   
   /** @param newCabArrendatario
    * @pdOid 62cbc728-bc1e-4bf1-a9f7-fd7b05d1435a */
   public void setCabArrendatario(String newCabArrendatario) {
      cabArrendatario = newCabArrendatario;
   }
   
   /** @pdOid 6354d4cf-086c-4cca-ac87-2db0108416ab */
   public String getCabArrendador() {
      return cabArrendador;
   }
   
   /** @param newCabArrendador
    * @pdOid f13ffc73-d0b7-47a8-ac3b-cfe3b31acb86 */
   public void setCabArrendador(String newCabArrendador) {
      cabArrendador = newCabArrendador;
   }
   
   /** @pdOid 8cab54dc-f9a1-497c-b009-6e2c73398630 */
   public String getCabObservacion() {
      return cabObservacion;
   }
   
   /** @param newCabObservacion
    * @pdOid 8eafadb2-a838-42f9-85e4-fb69d18b00f9 */
   public void setCabObservacion(String newCabObservacion) {
      cabObservacion = newCabObservacion;
   }
   
   /** @pdOid 5101e6d5-ab61-4edd-8e0a-6b8740958e95 */
   public char getCabEstado() {
      return cabEstado;
   }
   
   /** @param newCabEstado
    * @pdOid e0669d7b-9397-4553-be80-92b8654ee383 */
   public void setCabEstado(char newCabEstado) {
      cabEstado = newCabEstado;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<ArrContratoDet> getCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ArrContratoDet>();
      return con_det;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ArrContratoDet>();
      return con_det.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCon_det */
   public void setCon_det(java.util.List<ArrContratoDet> newCon_det) {
      removeAllCon_det();
      for (java.util.Iterator iter = newCon_det.iterator(); iter.hasNext();)
         addCon_det((ArrContratoDet)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArrContratoDet */
   public void addCon_det(ArrContratoDet newArrContratoDet) {
      if (newArrContratoDet == null)
         return;
      if (this.con_det == null)
         this.con_det = new java.util.Vector<ArrContratoDet>();
      if (!this.con_det.contains(newArrContratoDet))
      {
         this.con_det.add(newArrContratoDet);
         newArrContratoDet.setCon_cab(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldArrContratoDet */
   public void removeCon_det(ArrContratoDet oldArrContratoDet) {
      if (oldArrContratoDet == null)
         return;
      if (this.con_det != null)
         if (this.con_det.contains(oldArrContratoDet))
         {
            this.con_det.remove(oldArrContratoDet);
            oldArrContratoDet.setCon_cab((ArrContratoCab)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCon_det() {
      if (con_det != null)
      {
         ArrContratoDet oldArrContratoDet;
         for (java.util.Iterator iter = getIteratorCon_det(); iter.hasNext();)
         {
            oldArrContratoDet = (ArrContratoDet)iter.next();
            iter.remove();
            oldArrContratoDet.setCon_cab((ArrContratoCab)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ArrInter> getIntc() {
      if (intc == null)
         intc = new java.util.Vector<ArrInter>();
      return intc;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIntc() {
      if (intc == null)
         intc = new java.util.Vector<ArrInter>();
      return intc.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIntc */
   public void setIntc(java.util.List<ArrInter> newIntc) {
      removeAllIntc();
      for (java.util.Iterator iter = newIntc.iterator(); iter.hasNext();)
         addIntc((ArrInter)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArrInter */
   public void addIntc(ArrInter newArrInter) {
      if (newArrInter == null)
         return;
      if (this.intc == null)
         this.intc = new java.util.Vector<ArrInter>();
      if (!this.intc.contains(newArrInter))
      {
         this.intc.add(newArrInter);
         newArrInter.setCon_cab(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldArrInter */
   public void removeIntc(ArrInter oldArrInter) {
      if (oldArrInter == null)
         return;
      if (this.intc != null)
         if (this.intc.contains(oldArrInter))
         {
            this.intc.remove(oldArrInter);
            oldArrInter.setCon_cab((ArrContratoCab)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIntc() {
      if (intc != null)
      {
         ArrInter oldArrInter;
         for (java.util.Iterator iter = getIteratorIntc(); iter.hasNext();)
         {
            oldArrInter = (ArrInter)iter.next();
            iter.remove();
            oldArrInter.setCon_cab((ArrContratoCab)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ArrInterPer> getIntp() {
      if (intp == null)
         intp = new java.util.Vector<ArrInterPer>();
      return intp;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIntp() {
      if (intp == null)
         intp = new java.util.Vector<ArrInterPer>();
      return intp.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIntp */
   public void setIntp(java.util.List<ArrInterPer> newIntp) {
      removeAllIntp();
      for (java.util.Iterator iter = newIntp.iterator(); iter.hasNext();)
         addIntp((ArrInterPer)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArrInterPer */
   public void addIntp(ArrInterPer newArrInterPer) {
      if (newArrInterPer == null)
         return;
      if (this.intp == null)
         this.intp = new java.util.Vector<ArrInterPer>();
      if (!this.intp.contains(newArrInterPer))
      {
         this.intp.add(newArrInterPer);
         newArrInterPer.setCon_cab(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldArrInterPer */
   public void removeIntp(ArrInterPer oldArrInterPer) {
      if (oldArrInterPer == null)
         return;
      if (this.intp != null)
         if (this.intp.contains(oldArrInterPer))
         {
            this.intp.remove(oldArrInterPer);
            oldArrInterPer.setCon_cab((ArrContratoCab)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIntp() {
      if (intp != null)
      {
         ArrInterPer oldArrInterPer;
         for (java.util.Iterator iter = getIteratorIntp(); iter.hasNext();)
         {
            oldArrInterPer = (ArrInterPer)iter.next();
            iter.remove();
            oldArrInterPer.setCon_cab((ArrContratoCab)null);
         }
      }
   }

}
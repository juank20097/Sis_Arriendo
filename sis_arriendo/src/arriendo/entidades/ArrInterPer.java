/***********************************************************************
 * Module:  ArrInterPer.java
 * Author:  jestevez
 * Purpose: Defines the Class ArrInterPer
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid deb75e41-bf50-43e4-a31b-740fcd71eb03 */
public class ArrInterPer {
   /** @pdOid 68006ba9-36d8-4722-8b3f-e591febe1c4b */
   private Integer inpId;
   
   /** @pdOid 14ad1ff2-157c-457f-8038-1301056cbca1 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ArrContratoCab assc=association10 mult=1..1 */
   public ArrContratoCab con_cab;
   /** @pdRoleInfo migr=no name=GenPersona assc=association11 mult=1..1 */
   public GenPersona per;
   
   /** @pdOid 67b36a12-7ab9-405c-9696-4d142edb23e4 */
   public ArrInterPer() {
      // TODO: implement
   }
   
   /** @pdOid 4b0671a4-a8c4-4f8f-acaf-aeb0c635ae08 */
   public Integer getInpId() {
      return inpId;
   }
   
   /** @param newInpId
    * @pdOid f4515c5d-7f0d-491a-b10f-6aecf99e763e */
   public void setInpId(Integer newInpId) {
      inpId = newInpId;
   }
   
   
   /** @pdGenerated default parent getter */
   public ArrContratoCab getCon_cab() {
      return con_cab;
   }
   
   /** @pdGenerated default parent setter
     * @param newArrContratoCab */
   public void setCon_cab(ArrContratoCab newArrContratoCab) {
      if (this.con_cab == null || !this.con_cab.equals(newArrContratoCab))
      {
         if (this.con_cab != null)
         {
            ArrContratoCab oldArrContratoCab = this.con_cab;
            this.con_cab = null;
            oldArrContratoCab.removeIntp(this);
         }
         if (newArrContratoCab != null)
         {
            this.con_cab = newArrContratoCab;
            this.con_cab.addIntp(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public GenPersona getPer() {
      return per;
   }
   
   /** @pdGenerated default parent setter
     * @param newGenPersona */
   public void setPer(GenPersona newGenPersona) {
      if (this.per == null || !this.per.equals(newGenPersona))
      {
         if (this.per != null)
         {
            GenPersona oldGenPersona = this.per;
            this.per = null;
            oldGenPersona.removeIntp(this);
         }
         if (newGenPersona != null)
         {
            this.per = newGenPersona;
            this.per.addIntp(this);
         }
      }
   }

}
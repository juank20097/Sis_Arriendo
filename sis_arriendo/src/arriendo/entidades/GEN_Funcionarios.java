/***********************************************************************
 * Module:  GEN_Funcionarios.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Funcionarios
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 62b1d24c-d1dd-4e7b-9d0a-557aaa348149 */
public class GEN_Funcionarios extends GEN_Personas {
   /** @pdOid d44e8027-46e6-4c78-b71b-6add3681414d */
   private String fun_gerencia;
   /** @pdOid 16e1f17a-d192-4e3f-a176-15d5426f97d0 */
   private String fun_direccion;
   /** @pdOid 0bc6dd37-da3d-40aa-8097-646043f6d890 */
   private String fun_cargo;
   
   /** @pdOid 4709d2c5-a5c4-46a8-a5b6-cddcfdb26bf3 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdOid 4b4c497d-19ad-4c2c-b4e4-d40f00701c0f */
   public String getFun_gerencia() {
      return fun_gerencia;
   }
   
   /** @param newFun_gerencia
    * @pdOid 7de4a95c-8aa2-405a-a022-81d858229a0e */
   public void setFun_gerencia(String newFun_gerencia) {
      fun_gerencia = newFun_gerencia;
   }
   
   /** @pdOid 90d2f433-13ea-4482-a1d7-d4891256157a */
   public String getFun_direccion() {
      return fun_direccion;
   }
   
   /** @param newFun_direccion
    * @pdOid 629c3f47-5fdc-4c1b-9fe4-09bf382dd9cb */
   public void setFun_direccion(String newFun_direccion) {
      fun_direccion = newFun_direccion;
   }
   
   /** @pdOid 0c19fac5-6e74-409b-a821-3727f18656ec */
   public String getFun_cargo() {
      return fun_cargo;
   }
   
   /** @param newFun_cargo
    * @pdOid 37898c7b-d273-46d0-88ce-b2817e38a132 */
   public void setFun_cargo(String newFun_cargo) {
      fun_cargo = newFun_cargo;
   }
   
   /** @pdOid 77b3ba5b-90a7-4857-aef6-e7a1d751dbce */
   public GEN_Funcionarios() {
      // TODO: implement
   }

}
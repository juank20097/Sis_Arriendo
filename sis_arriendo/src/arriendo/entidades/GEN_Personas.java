/***********************************************************************
 * Module:  GEN_Personas.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Personas
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid d62f6c62-1c9d-4b39-8828-6744b9876576 */
public abstract class GEN_Personas {
   /** @pdOid fb81bd5c-37ce-4b35-aea1-71603459febe */
   private Integer per_id;
   /** @pdOid cae1af51-4469-4236-b93f-65bf8c311549 */
   private String per_tipo_id;
   /** @pdOid a1cefd49-bd3f-4b0c-84a3-5e67a2c14493 */
   private String per_nombres;
   /** @pdOid 5a791f3c-29ad-4a6c-9378-8666fc4802a4 */
   private String per_apellidos;
   /** @pdOid fecd9f5f-eede-423e-9d01-3801af4b7708 */
   private String per_correo;
   /** @pdOid 0fc5cd07-f23d-4334-b138-476edf2ca31c */
   private String per_telefono;
   /** @pdOid 17a5dc2f-b72f-4d22-9da2-6a694af85c83 */
   private String per_celular;
   /** @pdOid 9eedb4f3-62c4-4729-9db9-dd9cae2edc75 */
   private String per_nacionalidad;
   /** @pdOid dd18a80b-88d0-47f5-b018-11200f4a5329 */
   private String per_genero;
   /** @pdOid 85cb1b6b-2329-46f5-a6b7-7dc91c98413d */
   private byte[] per_foto;
   /** @pdOid 8aae07d8-c73a-4bc0-a7d2-d32a3e035eca */
   private byte[] per_huella;
   /** @pdOid cd964e05-c450-4038-b45d-e5389a0f8e65 */
   private int per_nro_articulos;
   
   /** @pdOid d7c1774f-9171-4bf4-9ff4-ae0498f64585 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdOid f6fa4d80-6ad3-476d-8f7f-2ad4fb2c8041 */
   public GEN_Personas() {
      // TODO: implement
   }
   
   /** @pdOid 7699631c-97aa-41c2-9994-860b4702a4fa */
   public Integer getPer_id() {
      return per_id;
   }
   
   /** @param newPer_id
    * @pdOid 673f3b1e-9656-417f-b7f8-5ecc2aeb3e12 */
   public void setPer_id(Integer newPer_id) {
      per_id = newPer_id;
   }
   
   /** @pdOid 1545af7f-9f64-4b7b-aa1a-86ed291f96a1 */
   public String getPer_tipo_id() {
      return per_tipo_id;
   }
   
   /** @param newPer_tipo_id
    * @pdOid fac37fea-5329-4aae-8d80-fe8cc9aca8aa */
   public void setPer_tipo_id(String newPer_tipo_id) {
      per_tipo_id = newPer_tipo_id;
   }
   
   /** @pdOid ee7c1e44-e56c-4dfc-bda1-0ae1f974ed4d */
   public String getPer_nombres() {
      return per_nombres;
   }
   
   /** @param newPer_nombres
    * @pdOid cb55757c-6850-49eb-b84d-465f9c5c1cbf */
   public void setPer_nombres(String newPer_nombres) {
      per_nombres = newPer_nombres;
   }
   
   /** @pdOid 3a40cd54-8de6-40f0-ae3f-df5421efeb60 */
   public String getPer_apellidos() {
      return per_apellidos;
   }
   
   /** @param newPer_apellidos
    * @pdOid fe902ab6-012c-486e-9aee-93f62e86b549 */
   public void setPer_apellidos(String newPer_apellidos) {
      per_apellidos = newPer_apellidos;
   }
   
   /** @pdOid af39aeaf-b567-4784-b40f-74af3c41b3f3 */
   public String getPer_correo() {
      return per_correo;
   }
   
   /** @param newPer_correo
    * @pdOid 228c0154-29fd-4b2c-864e-200b27df5985 */
   public void setPer_correo(String newPer_correo) {
      per_correo = newPer_correo;
   }
   
   /** @pdOid 5d21d304-5d6c-43f6-80e0-455d7171d2b5 */
   public String getPer_telefono() {
      return per_telefono;
   }
   
   /** @param newPer_telefono
    * @pdOid d7ce5648-8a25-4e53-96fc-e163050c2b46 */
   public void setPer_telefono(String newPer_telefono) {
      per_telefono = newPer_telefono;
   }
   
   /** @pdOid db9d5363-0ae6-458e-80ca-644fde45c19d */
   public String getPer_celular() {
      return per_celular;
   }
   
   /** @param newPer_celular
    * @pdOid 04f0e34b-f78b-4e29-bc7f-eff0dc831a13 */
   public void setPer_celular(String newPer_celular) {
      per_celular = newPer_celular;
   }
   
   /** @pdOid cea7d4c1-7433-440a-8f3e-969098eda6cb */
   public String getPer_nacionalidad() {
      return per_nacionalidad;
   }
   
   /** @param newPer_nacionalidad
    * @pdOid e4a29ac4-3f1b-4f88-89fc-3a1c651994a9 */
   public void setPer_nacionalidad(String newPer_nacionalidad) {
      per_nacionalidad = newPer_nacionalidad;
   }
   
   /** @pdOid ef3e05df-5891-4d9f-a597-698f77ffa964 */
   public String getPer_genero() {
      return per_genero;
   }
   
   /** @param newPer_genero
    * @pdOid d1610c38-67b0-4d38-9e02-e3b8f0b02de1 */
   public void setPer_genero(String newPer_genero) {
      per_genero = newPer_genero;
   }
   
   /** @pdOid ea0b8ae2-d619-4122-8d30-c8682d316a69 */
   public byte[] getPer_foto() {
      return per_foto;
   }
   
   /** @param newPer_foto
    * @pdOid 95078be9-346b-4592-8bb4-405ab1e8fd78 */
   public void setPer_foto(byte[] newPer_foto) {
      per_foto = newPer_foto;
   }
   
   /** @pdOid 2ee291a2-bd90-4470-a39d-221068e1eb6b */
   public byte[] getPer_huella() {
      return per_huella;
   }
   
   /** @param newPer_huella
    * @pdOid 54253094-02ce-4e95-9ca6-cd03f05a9219 */
   public void setPer_huella(byte[] newPer_huella) {
      per_huella = newPer_huella;
   }
   
   /** @pdOid a40e8306-c1cb-4ce4-8539-48dc663df9a4 */
   public int getPer_nro_articulos() {
      return per_nro_articulos;
   }
   
   /** @param newPer_nro_articulos
    * @pdOid 09f6b20d-734e-4218-917b-b2b8912c39b3 */
   public void setPer_nro_articulos(int newPer_nro_articulos) {
      per_nro_articulos = newPer_nro_articulos;
   }

}
package com.userCommand;


public class JoinError {
   private boolean IDexist;
   private boolean PWdisagree;
   private boolean idNull;
   private boolean pwNull;
   private boolean nameNull;
   private boolean addressNull;
   private boolean sexNull;
   private boolean birthdayNull;
   
   
   public JoinError() {
      IDexist = false;
      PWdisagree = false ;
      idNull = false;
      pwNull = false;
      nameNull = false;
      addressNull = false;
      sexNull = false;
      birthdayNull = false;
   }


   public boolean isIDexist() {
      return IDexist;
   }


   public void setIDexist(boolean iDexist) {
      IDexist = iDexist;
   }


   public boolean isPWdisagree() {
      return PWdisagree;
   }


   public void setPWdisagree(boolean pWdisagree) {
      PWdisagree = pWdisagree;
   }


   public boolean isIdNull() {
      return idNull;
   }


   public void setIdNull(boolean idNull) {
      this.idNull = idNull;
   }


   public boolean isPwNull() {
      return pwNull;
   }


   public void setPwNull(boolean pwNull) {
      this.pwNull = pwNull;
   }


   public boolean isNameNull() {
      return nameNull;
   }


   public void setNameNull(boolean nameNull) {
      this.nameNull = nameNull;
   }


   public boolean isAddressNull() {
      return addressNull;
   }


   public void setAddressNull(boolean addressNull) {
      this.addressNull = addressNull;
   }


   public boolean isSexNull() {
      return sexNull;
   }


   public void setSexNull(boolean sexNull) {
      this.sexNull = sexNull;
   }


   public boolean isBirthdayNull() {
      return birthdayNull;
   }


   public void setBirthdayNull(boolean birthdayNull) {
      this.birthdayNull = birthdayNull;
   }
   
   public boolean ExistError() {
      
      
      return (IDexist || PWdisagree || idNull || pwNull || nameNull || addressNull || sexNull || birthdayNull);
   }

}
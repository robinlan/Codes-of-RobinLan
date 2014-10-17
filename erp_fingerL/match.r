matching<-function(){
 erp<-read.csv("erp_finerL.csv")
 b<-c(0,0,0,0)
 for(i in 1:10749){
  bb<-c(erp[(10754+3*(i-1)):(10756+3*(i-1)),2],erp[(5+(i-1)),2])
  b<-cbind(b,bb)
 }
 b
}
package org.moh.electronicstore.KotlinCode
import java.time.LocalDate
import java.time.Period

enum class OperatingSystems{Windows, Mac, Android, Linux}
enum class PaymentType{Cash, Checks, DebitCards, CreditCards, MobilePayments, ElectronicBankTransfers}

data class Manufacturer(val ID:Int, val name:String, val country:String)
data class Customer(val ID:Int, val name:String, val country:String, val city:String)

open class ElectronicDevice(val seriaNum:String, val type:String, val dc:Double,
                            val manufacturer:Manufacturer?, val manufacturingDate:LocalDate?) {}

open class HandHeld(seriaNum:String, type:String, dc:Double, manufacturer:Manufacturer?, manufacturingDate:LocalDate,
                    val owner:Customer, val weight:Double): ElectronicDevice(seriaNum, type, dc, manufacturer,
    manufacturingDate){
    var os:OperatingSystems=OperatingSystems.Android
    var screenSize:String="Not initialized"
    //In the secondary class
    //use the word "constructor" to create it
    //No val or var
    //You have to call the primary constructor
    //You can create a primary constructor with no parameter
    //call the primary constructor  using this()
    //All parameters are private
    constructor(seriaNum:String, type:String, dc:Double, manufacturer:Manufacturer?, manufacturingDate:LocalDate,
                owner:Customer, weight:Double, OperatingSys:OperatingSystems,
                screenSize:String="Not initialized"):this(seriaNum, type, dc, manufacturer, manufacturingDate,
        owner, weight){
        this.os=OperatingSys
        this.screenSize=screenSize
    }
    fun getAge(): Pair<String, String> {
        if (manufacturingDate != null) {
            var age: Period = Period.between(manufacturingDate, LocalDate.now())
            return Pair("${age.getYears()} years"," ${age.getMonths()} month/s")
        } else {
            return Pair("0", "0")
        }
    }

}
class Mobile(seriaNum:String, type:String, dc:Double, manufacturer:Manufacturer?, manufacturingDate:LocalDate,
             owner:Customer, weight:Double, OperatingSys:OperatingSystems,screenSize:String,
             val celNumber:String):HandHeld(seriaNum, type, dc, manufacturer, manufacturingDate,
    owner, weight, OperatingSys,screenSize){
}

class CustomerPurchaseInfo(val cust:Customer, val device:ElectronicDevice, val paymentType: PaymentType,
                           val purchaseDate:LocalDate, val price:Double, var paidValue:Double, val warranty:Int){
    val isWarrantyIncluded:Boolean
        get() = if(warranty>0) true else false
    val isIndebted:Boolean
        get()= if(price>paidValue) true  else false
    val debt:Double=String.format("%.2f", price-paidValue).toDouble()
    fun getRemainingWarranty() : Pair<String, String> {
        if (isWarrantyIncluded) {
            var purchaseDate2:LocalDate=purchaseDate
            purchaseDate2=purchaseDate2.plusYears(warranty.toLong())
            if (purchaseDate2>LocalDate.now()){
                var age: Period = Period.between( LocalDate.now(), purchaseDate2)
                return Pair("${age.getYears()} years"," ${age.getMonths()} month/s")
            }
            else {
                return Pair("0", "0")
            }
        } else {
            return Pair("0", "0")
        }
    }
}
function getWiFi(lat,long){
var distance=[]
var shortestDistance = Math.sqrt(((lat-latitude[1]))*((lat-latitude[1])))+((long-longitude[1])*((long-longitude[1])))
var index

    for(var i=0; i<address.length; i++){
        distance.push(Math.sqrt(((lat-latitude[i]))*((lat-latitude[i])))+((long-longitude[i])*((long-longitude[i]))))
        if(distance[i]<shortestDistance){
            shortestDistance=distance[i]
            index=i
        }
    }            
return address[index]
}



function displayWiFi(){
    document.getElementById("output").innerHTML = getWiFi(document.getElementById("Latitude").value, document.getElementById("Longitude").value);
    if ((typeof getWiFi(document.getElementById("Latitude").value, document.getElementById("Longitude").value))=="undefined"){
        document.getElementById("output").innerHTML = "You are too far!"
            }
            
}

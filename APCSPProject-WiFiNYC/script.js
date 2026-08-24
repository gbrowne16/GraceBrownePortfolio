//This function was written by and provided to me by my teacher
function getColumn(url, columnNumber){
    var column = [];
    var table = [];
    var request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send(null);
    var csvData = new Array();
    var jsonObject = request.responseText.split(/\r?\n|\r/);
    for (var i = 0; i < jsonObject.length; i++) {
    csvData.push(jsonObject[i].split(/,(?=(?:(?:[^"]*"){2})*[^"]*$)/));
    }
    table = csvData;
    column = getCol(table, columnNumber);
    return column;
   }
    //This function was written by and provided to me by my teacher
   function getCol(matrix, col){
    var column = [];
    for(var i=1; i<matrix.length-1; i++){
    column.push(matrix[i][col]);
    }
    return column;
    }
   //This dataset about the locations of Public Wifi in NYC came from
   //https://www.kaggle.com/datasets/new-york-city/nyc-public-wifi
   //I accessed it through a repository provided to me by my teacher
   //(https://github.com/b-mcavoy/datasets/tree/main)
   url ="https://raw.githubusercontent.com/b-mcavoy/datasets/refs/heads/main/Miscellaneous/NYC%20Public%20Wifi%20Locations.csv"
   var address = getColumn(url, 2)
   var latitude = getColumn(url, 3)
   var longitude = getColumn(url, 4)
   //The procedure getWiFi takes parameters lat for latitude and long for longitude.
   // It returns a string for the address with the nearest public WiFi
   function getWiFi(lat,long){
   var distance=[]
   var shortestDistance =
   Math.sqrt(((lat-latitude[1]))*((lat-latitude[1])))+((long-longitude[1])*((long-longitude[1])))
   var index
    for(var i=0; i<address.length; i++){
   
   distance.push(Math.sqrt(((lat-latitude[i]))*((lat-latitude[i])))+((long-longitude[i])*
   ((long-longitude[i]))))
    if(distance[i]<shortestDistance){
    shortestDistance=distance[i]
    index=i
    }
    }
   return address[index]
   }
   //The procedure displayWiFi takes no parameters
   // It links the result of the procedure getWifi to the innerHTML
   function displayWiFi(){
    document.getElementById("output").innerHTML = getWiFi(document.getElementById("Latitude").value, document.getElementById("Longitude").value);
    if ((typeof getWiFi(document.getElementById("Latitude").value, document.getElementById("Longitude").value))=="undefined"){
    document.getElementById("output").innerHTML = "You are too far!"
    }
}
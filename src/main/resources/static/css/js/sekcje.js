  var sekcje = /*[[${listSekcje}]]*/;

$('#txtSearch').on.('keyup'), function(){
    var value= $(this).val();

  var data = FilterFunction(valuer, sekcje);

  rebuildTable(data)
});


funcion FilterFunkcjon(value, data){
var filterData = [];
for(var i = 0; i<data.length, i++){z    
value = value.toLowerCase();
var fname = data[i].nazwa.toLowerCase();

if(fname.includes(value)){
filteredData.push(data[i]);
}
}
return filteredData;
}


function rebuildTable(data)
var table = document.getElementById('sekcjeTable')
table.innerHTML=''
for(var i = 0; i <data.length; i++) {
var row = <tr>
    <td>${data[i].idsekcja}</td>
    <td>${data[i].nazwa}</td>
    </tr>
    table.innerHTML += row
    }
    }
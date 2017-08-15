/**
 * Created by msun2 on 14/08/2017.
 */
$(document).ready(function() {

    var setTable = function(data) {

        var trs = $('.table > tbody > tr ');
        trs[0].innerHTML = "<td>City</td><td>"+data.city+"</td>";
        trs[1].innerHTML = "<td>Updated time</td><td>"+data.updateTme+"</td>";
        trs[2].innerHTML = "<td>Weather</td><td>"+data.weather+"</td>";
        trs[3].innerHTML = "<td>Temperature</td><td>"+data.temperature+"</td>";
        trs[4].innerHTML = "<td>Wind</td><td>"+data.wind+"</td>";

    };

    $.ajax({
        url: "http://localhost:8080/weather"
    }).then(function(data, status, jqxhr) {
        setTable(data);
    });


    $('.dropdown-menu > li > a').click(function(event){
        var city = $(this).text();

        $.ajax({ url: 'http://localhost:8080/weather?city='+city}).then(function(data, status, jqxhr) {
                setTable(data);
            });
    });
});


$(document).ready(function() {

    $(document).on('click', '#getAllAlgos', function (e) {
        e.preventDefault();
        getAllAlgos();
    })

    $(document).on('click', '#postText', function (e) {
        e.preventDefault();
        postAlgo();
    })

    function postAlgo() {
        var formData = {
            text: $("#textValue").val(),
            algo: $("#algorithm").val()
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: window.location + "encrypt",
            data: JSON.stringify(formData),
            success: function (data) {
                var upperCase = data.toUpperCase();
                $("#postAlgo").html("<h3 class='text-center'>" + upperCase + "</h3>")
            },
            error: function (e) {
                alert("Error")
            }
        });
        resetData();
    }

    function resetData(){
        $("#firstname").val("");
        $("#lastname").val("");
    }

    function getAllAlgos(){

        $.ajax({
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            url: window.location + "encrypt/algos"
        }).done(function(data) {
            $('#getResultDiv ul').empty();
            var algosList = '';

            $.each(data, function(i, algo){
                debugger
                console.log(data[i].name)
                var alg = "Algo name: " + data[i].name + "<br>";
                $('#getResultDiv .list-group').append(alg);
            });
            console.log("Success: " + data);
        }
        // .fail(function(result){
        //     $("#getResultDiv").html("<strong>Error</strong>");
        // })

    );
    }



});
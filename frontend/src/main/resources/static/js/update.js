var table = document.getElementById("table"),rIndex;

    for(var i = 1; i < table.rows.length; i++)
    {
        table.rows[i].onclick = function()
        {
            rIndex = this.rowIndex;
            console.log(rIndex);

            document.getElementById("userid").value = this.cells[1].innerHTML;
            document.getElementById("status").value = this.cells[3].innerHTML;
            document.getElementById("printWidth").value = this.cells[4].innerHTML;
            document.getElementById("printHeight").value = this.cells[5].innerHTML;
        };
    }
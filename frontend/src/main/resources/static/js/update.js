const table = document.getElementById("table");

for(let i = 1; i < table.rows.length; i++)
{
    table.rows[i].onclick = function()
    {
        document.querySelector(".update #id").value = this.cells[0].innerHTML;
        document.querySelector(".update #status").selectedIndex = this.cells[3].id;
    };
}
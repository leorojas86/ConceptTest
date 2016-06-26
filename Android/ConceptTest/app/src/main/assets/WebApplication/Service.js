//Singleton instance
var ServiceClient = { instance: new ServiceClientClass() };

//Variables
//ServiceClientClass.prototype._templateVariable = null;

//Constructors
function ServiceClientClass()
{
}

//Methods
ServiceClientClass.prototype.initialize = function()
{
    window.external.SQLiteCreateFile("MyDatabase.sqlite");
    window.external.SQLiteOpenConnection("Data Source=MyDatabase.sqlite;Version=3;");
    window.external.SQLiteExecuteNonQuery("CREATE TABLE users (name VARCHAR(20), password VARCHAR(20))");
    window.external.SQLiteExecuteNonQuery("INSERT INTO users (name, password) values ('Test', 123)");
};

ServiceClientClass.prototype.login = function(name, password)
{
    var query = "SELECT name, password FROM users WHERE name = '" + name + "' AND password = '" + password + "'";
    var resultString = window.external.SQLiteExecuteSelect(query);
    var result = JSON.parse(resultString);

    //alert("resultString = " + resultString);

    //var test = window.external.SQLiteExecuteNonQuery("INSERT INTO users (name, password) values ('Test', 123)");
    //alert("test = " + test);

    return result.rows.length > 0;
};

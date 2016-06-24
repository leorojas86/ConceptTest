using System.Windows.Forms;
using System.Runtime.InteropServices;
using System.Data.SQLite;

namespace WindowsFormsApplication1
{
    [ComVisible(true)]
    public class ObjectForScripting
    {
        public void sendMessage(string text)
        {
            MessageBox.Show(text);
            TestSQLite();
        }

        private void TestSQLite()
        {
            //http://sqlitebrowser.org/
            SQLiteConnection.CreateFile("MyDatabase.sqlite");
            SQLiteConnection connection = new SQLiteConnection("Data Source=MyDatabase.sqlite;Version=3;");
            connection.Open();
            string sql = "CREATE TABLE highscores (name VARCHAR(20), score INT)";

            SQLiteCommand command = new SQLiteCommand(sql, connection);
            command.ExecuteNonQuery();

            string sql2 = "insert into highscores (name, score) values ('Me', 9001)";
            SQLiteCommand command2 = new SQLiteCommand(sql2, connection);
            command2.ExecuteNonQuery();
        }
    }
}

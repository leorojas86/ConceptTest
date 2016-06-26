using System.Collections.Generic;
using System.Data.SQLite;

namespace WindowsFormsApplication1
{
    public class SQLiteWrapper
    {
        private SQLiteConnection _connection = null;

        public SQLiteWrapper()
        {
        }

        public void CreateFile(string fileName)
        {
            SQLiteConnection.CreateFile(fileName);
        }

        public void OpenConnection(string connectionSettings)
        {
            _connection = new SQLiteConnection(connectionSettings);
            _connection.Open();
        }

        public string ExecuteNonQuery(string query)
        {
            SQLiteCommand command               = new SQLiteCommand(query, _connection);
            int affectedRows                    = command.ExecuteNonQuery();
            Dictionary<string, object> values   = new Dictionary<string, object>() { { "AffectedRows", affectedRows.ToString() } };
            string json                         = Json.JsonParser.ToJson(values);
            return json;
        }

        public string ExecuteSelect(string query)
        {
            SQLiteCommand command                 = new SQLiteCommand(query, _connection);
            SQLiteDataReader reader               = command.ExecuteReader(System.Data.CommandBehavior.Default);
            List<Dictionary<string, object>> rows = new List<Dictionary<string, object>>();

            while(reader.Read() && reader.HasRows)
            {
                Dictionary<string, object> currentRow = new Dictionary<string, object>();

                for(int i = 0; i < reader.FieldCount; i++)
                {
                    string key   = reader.GetName(i);
                    object value = reader.GetValue(i);

                    currentRow.Add(key, value);
                }

                rows.Add(currentRow);
            }

            Dictionary<string, object> values   = new Dictionary<string, object>() { { "rows", rows } };
            string json                         = Json.JsonParser.ToJson(values);

            return json;
        }
    }
}

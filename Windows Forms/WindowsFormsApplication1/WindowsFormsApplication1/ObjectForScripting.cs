using System.Windows.Forms;
using System.Runtime.InteropServices;

namespace WindowsFormsApplication1
{
    [ComVisible(true)]
    public class ObjectForScripting
    {
        public void sendMessage(string text)
        {
            MessageBox.Show(text);
        }
    }
}

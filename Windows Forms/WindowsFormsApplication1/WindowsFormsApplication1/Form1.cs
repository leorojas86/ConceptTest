using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            this.webBrowser1.Navigate(AppDomain.CurrentDomain.BaseDirectory + "WebApplication/index.html");
        }

        //http://blog.ropardo.ro/2010/05/19/windows-application-interaction-with-a-web-page/
        private void webBrowser1_DocumentCompleted(object sender, WebBrowserDocumentCompletedEventArgs e)
        {
            var result = this.webBrowser1.Document.InvokeScript("showText", new object[1] { "Windows Application Call" });
        }
    }
}

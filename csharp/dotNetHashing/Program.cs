using System;
using System.Diagnostics;
using System.Text;

namespace dotNetHashing
{
    class Program
    {
        static void Main(string[] args)
        {
            const string plainText = "test string";
            var salt = HashingHelper.GetSalt();
            Console.WriteLine(string.Format("salt: {0}", salt));
            Console.WriteLine(string.Format("hash: {0}", HashingHelper.Hash(plainText, salt)));

            const string known = "The quick brown fox jumps over the lazy dog";
            var knownHashAsciiEncoding = "2fd4e1c67a2d28fced849ee1bb76e7391b93eb12".ToUpper();
            var myHashAsciiEncoding = HashingHelper.Hash(known, Encoding.ASCII);

            Debug.Assert(knownHashAsciiEncoding.Equals(myHashAsciiEncoding));
        }
    }
}

using System;
using System.Security.Cryptography;
using System.Text;

namespace dotNetHashing
{
    public class HashingHelper
    {
        public static string GetSalt()
        {
            var baseline = new DateTime(1970, 1, 1);
            var current = DateTime.UtcNow;
            return ""+(current - baseline).Ticks/TimeSpan.TicksPerMillisecond;
        }

        public static string Hash(string plaingText, string salt)
        {
            var stringToHash = string.Format("{0}-{1}", plaingText, salt);
            return Hash(stringToHash);
        }

        public static string Hash(string stringToHash)
        {
            return Hash(stringToHash, Encoding.Unicode);
        }

        public static string Hash(string stringToHash, Encoding encoding)
        {
            var plainBytes = encoding.GetBytes(stringToHash);
            var hasher = new SHA1CryptoServiceProvider();
            var hash = BitConverter.ToString(hasher.ComputeHash(plainBytes));
            return hash.ToUpper().Replace("-", "");
        }
    }
}

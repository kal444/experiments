using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NHibernateTest.Entities
{
    public class StoreQueryResult
    {
        public virtual int Id { get; set; }

        public virtual string Result { get; set; }
    }
}
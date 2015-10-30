using FluentNHibernate.Mapping;
using NHibernateTest.Entities;

namespace NHibernateTest.Mappings
{
    public class ProductMap : ClassMap<Product>
    {
        public ProductMap()
        {
            Id(x => x.Id);
            Map(x => x.Name);
            Map(x => x.Price);
            HasManyToMany(x => x.StoresStockedIn)
                .Cascade.All()
                .Inverse()
                .WithTableName("StoreProduct");
        }
    }
}
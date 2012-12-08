using FluentNHibernate.Mapping;
using NHibernateTest.Entities;

namespace NHibernateTest.Mappings
{
    public class StoreMap : ClassMap<Store>
    {
        public StoreMap()
        {
            Id(x => x.Id);
            Map(x => x.Name);
            HasManyToMany(x => x.Products)
                .Cascade.All()
                .WithTableName("StoreProduct");
            HasMany(x => x.Staff)
                .Cascade.All()
                .Inverse();
        }
    }
}
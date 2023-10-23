using WebKovbasa.Data.Entities;
using WebKovbasa.Models.Category;
using AutoMapper;

namespace WebKovbasa.Mapper;

    public class AppMapProfile : Profile
    {
        public AppMapProfile()
        {
            CreateMap<CategoryEntity, CategoryItemViewModel>();
            CreateMap<CategoryCreateViewModel, CategoryEntity>();
        }
    }

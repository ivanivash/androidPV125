
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.FileProviders;
using WebKovbasa.Data;
using WebKovbasa.Mapper;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddDbContext<AppEFContext>(opt =>
    opt.UseNpgsql(builder.Configuration.GetConnectionString("WebKovbasaConnection")));
builder.Services.AddAutoMapper(typeof(AppMapProfile));
var app = builder.Build();


var dir = Path.Combine(Directory.GetCurrentDirectory(), "images");

if(!Directory.Exists(dir))
{
    Directory.CreateDirectory(dir);
}
app.UseStaticFiles(new StaticFileOptions
{
    FileProvider = new PhysicalFileProvider(dir),
    RequestPath = "/images"
});
app.SeedData(); 

app.Run();
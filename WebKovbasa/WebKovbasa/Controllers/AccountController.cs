using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using WebKovbasa.Constants;
using WebKovbasa.Data.Entities.Identity;
using WebKovbasa.Models.Account;

namespace WebKovbasa.Controllers;

public class AccountController : Controller
{
    private readonly UserManager<UserEntity> _userManager;
    public AccountController(UserManager<UserEntity> userManager)
    {
        _userManager = userManager;
    }
    [HttpPost("register")]
    public async Task<IActionResult> Register([FromBody] RegisterUserViewModel model)
    {
        UserEntity user = new UserEntity()
        {
            FirstName = model.FirstName,
            LastName = model.LastName,
            UserName = model.Email,
            Email = model.Email
        };

        var result = await _userManager.CreateAsync(user, model.Password);
        if (result.Succeeded)
        {
            result = await _userManager.AddToRoleAsync(user, Roles.User);
            return Ok();
        }
        else
        {
            return BadRequest();
        }
    }
}
document
  .getElementById("loginForm")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    const formData = new URLSearchParams(
      new FormData(document.getElementById("loginForm"))
    );

    fetch("/auth/login", {
      method: "POST",
      body: formData,
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
    })
      .then((response) => {
        if (response.ok) {
          return response.json();
        }
        throw new Error("Login failed");
      })
      .then((data) => {
        localStorage.setItem("token", data.token);
        window.location.href = "/home"; // Redirigir a la página "home"
      })
      .catch((error) => {
        console.error(error);
        // Manejar el error de inicio de sesión
      });
  });

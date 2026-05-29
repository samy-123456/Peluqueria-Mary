// TODO CUANDO CARGA LA PÁGINA
document.addEventListener("DOMContentLoaded", () => {

    /* ===== CARRUSEL INDEX ===== */
    const carrusel = document.querySelector(".carrusel-servicios .carrusel-contened");
    const next = document.querySelector(".next1");
    const prev = document.querySelector(".prev1");

    if (carrusel && next && prev) {
        let index = 0;
        const total = carrusel.children.length;

        next.onclick = () => {
            index = (index + 1) % total;
            carrusel.style.transform = `translateX(-${index * 100}%)`;
        };

        prev.onclick = () => {
            index = (index - 1 + total) % total;
            carrusel.style.transform = `translateX(-${index * 100}%)`;
        };
    }

    /* ===== CARRUSEL CERTIFICACIONES ===== */
    const carrusel2 = document.querySelector(".carrusel-contenedor");
    const next2 = document.querySelector(".next");
    const prev2 = document.querySelector(".prev");

    if (carrusel2 && next2 && prev2) {
        let index2 = 0;
        const total2 = carrusel2.children.length;

        next2.onclick = () => {
            index2 = (index2 + 1) % total2;
            carrusel2.style.transform = `translateX(-${index2 * 100}%)`;
        };

        prev2.onclick = () => {
            index2 = (index2 - 1 + total2) % total2;
            carrusel2.style.transform = `translateX(-${index2 * 100}%)`;
        };
    }

    /* ===== CARRUSEL VIDEOS ===== */
    const carruselVideo = document.querySelector(".video-carrusel");
    const nextV = document.querySelector(".next-video");
    const prevV = document.querySelector(".prev-video");

    if (carruselVideo && nextV && prevV) {
        let indexV = 0;
        const totalV = carruselVideo.children.length;

        nextV.onclick = () => {
            indexV = (indexV + 1) % totalV;
            carruselVideo.style.transform = `translateX(-${indexV * 100}%)`;
        };

        prevV.onclick = () => {
            indexV = (indexV - 1 + totalV) % totalV;
            carruselVideo.style.transform = `translateX(-${indexV * 100}%)`;
        };
    }

});


/* ===== MENÚ (FUERA) ===== */
function toggleMenu() {
    const menu = document.getElementById("menu-lateral");
    const overlay = document.getElementById("overlay");

    if (menu && overlay) {
        menu.classList.toggle("activo");
        overlay.classList.toggle("activo");
    }
}

function cerrarMenu() {
    const menu = document.getElementById("menu-lateral");
    const overlay = document.getElementById("overlay");

    if (menu && overlay) {
        menu.classList.remove("activo");
        overlay.classList.remove("activo");
    }
}
function mostrarMapa() {
  const mapa = document.getElementById("mapa");
  const btn = event.target;

  mapa.classList.toggle("oculto");

  if (mapa.classList.contains("oculto")) {
    btn.textContent = "Ver ubicación";
  } else {
    btn.textContent = "Ocultar ubicación";
  }
}

setInterval(() => {
  const nextBtn = document.querySelector(".next-video");
  if (nextBtn) {
    nextBtn.click();
  }
}, 5000);
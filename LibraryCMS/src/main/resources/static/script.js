const tooltip = document.getElementById("tooltip");

function showTooltip(event, title, author) {
  tooltip.innerHTML = `<strong>${title}</strong><br /><span>${author}</span>`;
  tooltip.style.left = event.pageX + 15 + "px";
  tooltip.style.top = event.pageY + 15 + "px";
  tooltip.classList.remove("hidden");
}

function hideTooltip() {
  tooltip.classList.add("hidden");
}
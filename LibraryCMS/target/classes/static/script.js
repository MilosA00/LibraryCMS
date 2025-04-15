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

function showHome() {
  const main = document.getElementById("main-content");
  main.innerHTML = `<h2 class="text-xl font-bold mb-4">Welcome to your Library CMS</h2>`;
}

function showAllBooks() {
  const main = document.getElementById("main-content");
  main.innerHTML = `
    <div class="mb-6">
      <input
        type="text"
        placeholder="Search books..."
        class="w-full px-4 py-2 rounded bg-searchBg placeholder-searchPlaceholder text-text"
        id="searchInput"
      />
    </div>
    <div id="bookGrid" class="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-5 gap-4">
      <div
        class="relative bg-sidebar p-2 rounded hover:ring-2 hover:ring-accent cursor-pointer"
        onmouseover="showTooltip(event, 'The Great Gatsby', 'F. Scott Fitzgerald')"
        onmouseout="hideTooltip()"
      >
        <img src="https://via.placeholder.com/150x220" alt="Book Cover" class="rounded" />
      </div>
    </div>
  `;
}

function showAddBookForm() {
  const main = document.getElementById("main-content");
  main.innerHTML = `
    <h2 class="text-xl font-bold mb-4">Add a New Book</h2>
    <form onsubmit="event.preventDefault(); alert('Book saved!');">
      <input type="text" placeholder="Title" class="block mb-2 w-full p-2 rounded bg-searchBg text-text" required />
      <input type="text" placeholder="ISBN" class="block mb-2 w-full p-2 rounded bg-searchBg text-text" required />
      <textarea placeholder="Summary" maxlength="2000" class="block w-full p-2 rounded bg-searchBg text-text mb-2" required></textarea>
      <input type="date" placeholder="Publication Date" class="block mb-2 w-full p-2 rounded bg-searchBg text-text" />
      <input type="number" placeholder="Page Count" class="block mb-4 w-full p-2 rounded bg-searchBg text-text" />
      <button type="submit" class="bg-accent px-4 py-2 rounded text-white">Save Book</button>
    </form>
  `;
}

function showFavorites() {
  const main = document.getElementById("main-content");
  main.innerHTML = `<h2 class="text-xl font-bold mb-4">Favorites</h2><p>You have no favorite books yet.</p>`;
}

// Load home by default
window.onload = showHome;
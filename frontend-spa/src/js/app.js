import home from "./home.js";
import header from "./header.js";
import footer from "./footer.js";
import albumView from "./albumView.js";

const container = document.querySelector(".container");

function makeHomeView() {
  fetch("http://localhost:8080/api/albums")
    .then((res) => res.json())
    .then((albums) => {
      container.innerHTML = header();
      container.innerHTML += home(albums);
      container.innerHTML += footer();

      const albumElement = document.querySelectorAll(".albumElement");

      albumElement.forEach((album) => {
        const albumDeleteButton = album.querySelector(".albumDeleteButton");

        albumDeleteButton.addEventListener("click", () => {
          let albumId = album.querySelector(".id_field");
          // alert(albumId.value);
          fetch(
            `http://localhost:8080/api/albums/${albumId.value}/deleteAlbumById`,
            {
              method: "DELETE",
            }
          )
            .then((res) => res.json())
            .then((album) => {
              console.log();
              makeHomeView();
            });
        });

        const albumButton = album.querySelector(".albumButton");

        albumButton.addEventListener("click", () => {
          let albumId = album.querySelector(".id_field");
          //   console.log(albumId);
          makeAlbumView(albumId.value);
        });
      });


      const albumArtistIn = document.querySelector(".albumArtistIn");
      const albumNameIn = document.querySelector(".albumNameIn");
      const albumLabelIn = document.querySelector(".albumLabelIn");
      const albumDescriptionIn = document.querySelector(".albumDescriptionIn");
      const albumImgIn = document.querySelector(".albumImgIn");

      const addAlbumButton = document.querySelector(".addAlbumButton");
      addAlbumButton.addEventListener("click", () => {
        const newAlbumJson = {
          name: albumNameIn.value,
          description: albumDescriptionIn.value,
          artist: albumArtistIn.value,
          label: albumLabelIn.value,
          imgUrl: albumImgIn.value,
        };

        console.log(newAlbumJson);

        fetch(`http://localhost:8080/api/addAlbums`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(newAlbumJson),
        })
          .then((res) => res.json())
          .then((album) => {
            makeHomeView();
          });
      });
    });
}

function makeAlbumView(albumId) {
  fetch(`http://localhost:8080/api/albums/${albumId}`)
    .then((res) => res.json())
    .then((album) => {
      // console.log(album);

      container.innerHTML = header();
      container.innerHTML += albumView(album);
      container.innerHTML += footer();

      const backButton = document.querySelector(".home-navigation");

      backButton.addEventListener("click", () => {
        makeHomeView();
      });

      const songNameIn = container.querySelector(".songNameInput");
      const artistNameIn = container.querySelector(".artistName");
      const songDurationMinIn = container.querySelector(".songDurationInputMin");
      const songDurationSecIn = container.querySelector(".songDurationInputSec");
      const addSongButton = container.querySelector(".addSongButton");
      const addReviewButton = container.querySelector(".addReviewButton");
      const albumCommentIn = container.querySelector(".albumCommentInput");
      const albumRatingInput = container.querySelector(".albumRatingInput");
      const albumName = container.querySelector(".albumName");

      addSongButton.addEventListener("click", () => {
        const newSongJson = {
          name: songNameIn.value,
          duration: songDurationMinIn.value + ":" + songDurationSecIn.value,
          artist: artistNameIn.value,
        };
        // alert(newSongJson);
        fetch(`http://localhost:8080/api/albums/${albumId}/addSong`, {
          method: "PATCH",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(newSongJson),
        })
          .then((res) => res.json())
          .then((album) => {
            makeAlbumView(albumId);
          });
      });

      addReviewButton.addEventListener("click", () => {
        const newReviewJson = {
          content: albumCommentIn.value,
          rating: albumRatingInput.value,
          // rating: 5,
          album: albumName.value
        };
        // alert(newReviewJson);

        fetch(`http://localhost:8080/api/albums/${albumId}/addReview`, {
          method: "PATCH",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(newReviewJson),
        })
          .then((res) => res.json())
          .then((album) => {
            makeAlbumView(albumId);
          });
      });

    });
}

makeHomeView();

export default function home(albums) {
  let seed = Math.floor(Math.random() * 100);
  let randomImage = "https://picsum.photos/200/200?random=" + seed;

  https: return `

        <div class="containter m-3">
            <div class="row row-cols-1 row-cols-md-4 g-4">
                ${albums
                  .map((album) => {
                    return `

                        <div class="albumElement col">
                            <div class="card h-100">

                            <img class="card-img-top" src="${album.imgUrl}">
                         
                            <div class="card-body">

                                <h5 class="card-title">${album.artist} - ${album.name} (${album.label})</h5>
                                <p class="card-text">${album.description}</p>

                                    <div class="float-start text-beginning">
                                        <a href="#" class="albumButton btn btn-sm btn-primary">More Info</a>
                                    </div>

                                    <div class="float-end text-end">
                                        <a href="#" class="albumDeleteButton btn btn-sm btn-danger">Delete</a>
                                    </div>

                                    <input class="id_field" hidden value="${album.id}">

                            </div>

                          </div>
                        </div>
                        `;
                  })
                  .join("")}
                        <div class="col">
                            <div class="card h-100">
                         
                            <div class="card-body">

                                <div class="row m-1">
                                    <div class="col">
                                        <input type="text" class="form-control albumArtistIn" placeholder="Artist name" aria-label="Artist name" value="Artist name">
                                    </div>
                                </div>
                                
                                <div class="row m-1">
                                    <div class="col">
                                        <input type="text" class="form-control albumNameIn" placeholder="Album name" aria-label="Album name" value="Album name">
                                    </div>
                                </div>

                                <div class="row m-1">
                                    <div class="col">
                                        <input type="text" class="form-control albumLabelIn" placeholder="Record label" aria-label="Record label" value="Record label">
                                    </div>
                                </div>

                                <div class="row m-1">
                                    <div class="col">
                                        <input type="text" class="form-control albumDescriptionIn" placeholder="Description" aria-label="Description" value="Description">
                                    </div>
                                </div>

                                <div class="row m-1">
                                    <div class="col">
                                        <input type="text" class="form-control albumImgIn" placeholder="Album cover html" aria-label="Album cover html" value=${randomImage}>
                                    </div>
                                </div>
                                
                                <div class="row m-2">
                                </div>
                                
                                <div class="row m-1">
                                    <div class="col">
                                        <div class="text-end">
                                            <a href="#" class="addAlbumButton btn btn-sm btn-success">Add Album</a>
                                        </div>
                                    </div>
                                </div>

                            </div>

                          </div>
                        </div>
            </div>
    </div>
    `;
}

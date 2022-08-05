export default function albumView(album) {

    return `
  
    <div class="containter m-3">

        <div class="row">
            
            <div class="albumElement col-6">
                <div class="card">

                    <img class="card-img-top" src="${album.imgUrl}">
                    <div class="card-body">
                        <h5 class="card-title">${album.artist} - ${
      album.name
    } (${album.label})</h5>
                        <p class="card-text">${album.description}</p>
                        <input class="id_field" hidden value="${album.id}">
                        <input class="artistName" hidden value="${
                          album.artist
                        }">
                        <input class="albumName" hidden value="${album.name}">
                    </div>

                </div>
            </div>

            <div class="col-6">
                <ol class="list-group list-group-numbered">
                  ${album.songs
                    .map((songs) => {
                      return `
                      <li class="list-group-item">${songs.name} - ${songs.duration}</li>
                      `;
                    })
                    .join("")}
                </ol>
            </div>

        </div>

        <div class="row mt-3">

            <div class="col-5">
                
                <h3 class="mt-5">Have something to say?</h3>

                <ul class="list-group list-group-flush">
                  ${album.reviews
                    .map((reviews) => {
                      return `
                      <li class="list-group-item">[${reviews.rating}/10] ${reviews.content}</li>
                      `;
                    })
                    .join("")}
                </ul>

                <div class="form-floating mt-2">
                    <input type="text" class="albumCommentInput form-control" id="floatingInputGrid" placeholder="" value="Example comment!">
                    <label for="floatingInputGrid">Comments</label>
                </div>
                
                <select class="form-select mt-2 albumRatingInput" aria-label="Default select example" required>
                    <option selected disabled>Album Rating</option>
                    <option value=1>1</option>
                    <option value=2>2</option>
                    <option value=3>3</option>
                    <option value=4>4</option>
                    <option value=5>5</option>
                    <option value=6>6</option>
                    <option value=7>7</option>
                    <option value=8>8</option>
                    <option value=9>9</option>
                    <option value=10>10</option>
                </select>

                <button class="addReviewButton btn btn-primary mt-2" type="submit">Add review</button>

            </div>
            
        <div class="col">
        </div>
            
            <div class="col-5">
                
                <h3 class="mt-5">Add more songs!</h3>
                
                <div class="form-floating mt-2">
                    <input type="text" class="songNameInput form-control" id="floatingInputGrid" placeholder="Song name" value="Example song">
                    <label for="floatingInputGrid">Song name</label>
                </div>
                
                <div class="row">
                    <div class="col-6">
                        <div class="form-floating mt-2">
                        <input type="text" class="songDurationInputMin form-control" id="floatingInputGrid" placeholder="Song duration (mins)" value="2">
                        <label for="floatingInputGrid">Minutes</label>
                        </div>
                    </div>
                    
                    <div class="col-6">
                        <div class="form-floating mt-2">
                            <input type="text" class="songDurationInputSec form-control" id="floatingInputGrid" placeholder="Song duration (secs)" value="14">
                            <label for="floatingInputGrid">Seconds</label>
                        </div>
                    </div>
                </div>
            
                <button class="addSongButton btn btn-primary mt-2" type="submit">Add song</button>
                
            </div>

        </div>  
        
    </div>



    

    `;
}
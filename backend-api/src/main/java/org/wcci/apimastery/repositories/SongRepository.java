package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.model.Song;

public interface SongRepository extends CrudRepository<Song,Long> {
}

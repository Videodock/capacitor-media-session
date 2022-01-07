# capacitor-media-session

Capacitor plugin which manages the media session and fire media events for Android TV.

## Install

```bash
npm install capacitor-media-session
npx cap sync
```

## API

<docgen-index>

* [`initMediaSession(...)`](#initmediasession)
* [`releaseMediaSession()`](#releasemediasession)
* [`setMediaState(...)`](#setmediastate)
* [`addListener('mediaSessionEvent', ...)`](#addlistenermediasessionevent)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### initMediaSession(...)

```typescript
initMediaSession(mediaState: MediaState) => Promise<{ call: string; }>
```

| Param            | Type                                              |
| ---------------- | ------------------------------------------------- |
| **`mediaState`** | <code><a href="#mediastate">MediaState</a></code> |

**Returns:** <code>Promise&lt;{ call: string; }&gt;</code>

--------------------


### releaseMediaSession()

```typescript
releaseMediaSession() => Promise<{ call: string; }>
```

**Returns:** <code>Promise&lt;{ call: string; }&gt;</code>

--------------------


### setMediaState(...)

```typescript
setMediaState(mediaState: MediaState) => Promise<{ call: string; mediaState: MediaState; }>
```

| Param            | Type                                              |
| ---------------- | ------------------------------------------------- |
| **`mediaState`** | <code><a href="#mediastate">MediaState</a></code> |

**Returns:** <code>Promise&lt;{ call: string; mediaState: <a href="#mediastate">MediaState</a>; }&gt;</code>

--------------------


### addListener('mediaSessionEvent', ...)

```typescript
addListener(eventName: 'mediaSessionEvent', listenerFunc: MediaSessionListenerFunc) => Promise<PluginListenerHandle> & PluginListenerHandle
```

| Param              | Type                                                                          |
| ------------------ | ----------------------------------------------------------------------------- |
| **`eventName`**    | <code>'mediaSessionEvent'</code>                                              |
| **`listenerFunc`** | <code><a href="#mediasessionlistenerfunc">MediaSessionListenerFunc</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |


### Type Aliases


#### MediaState

<code>{ isPlaying: boolean; isActive: boolean; title: string; subtitle: string; artworkUri: string; position: number; }</code>


#### MediaSessionListenerFunc

<code>(event: <a href="#mediasessionevent">MediaSessionEvent</a>): void</code>


#### MediaSessionEvent

<code>{ eventName: <a href="#mediasessioneventtype">MediaSessionEventType</a> }</code>


#### MediaSessionEventType

<code>'onPlay' | 'onPause' | 'onPausePlay' | 'onStop' | 'onNext' | 'onPrev' | 'onFastForward' | 'onRewind'</code>

</docgen-api>
